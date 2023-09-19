n = 26 # число обнаруженных ошибок
X = [9.0, 12.0, 11.0, 4.0, 7.0, 2.0,
     5.0, 8.0, 5.0, 7.0, 1.0, 6.0, 1.0,
     9.0, 4.0, 1.0, 3.0, 3.0, 6.0, 1.0,
     11.0, 33.0, 7.0, 91.0, 2.0, 1.0] # интервал времени до появления i-й ошибки.
a = n # Начальное значение интервала
b = 40 # Конечное значение интервала
tolerance = 1e-3 # Точность

def f(B, n, X):
    numerator = sum(1 / (B - i + 1) for i in range(1, n) if B > i - 1)
    denominator = (B + 1) * sum(X) - sum(i * X[i - 1] for i in range(1, n))
    return numerator - n * sum(X) / denominator

def bisection_method(f, a, b, tol, n, X):
    while (b - a) > tol:
        midpoint = (a + b) / 2.0
        if f(midpoint, n, X) == 0:
            return midpoint
        elif f(a, n, X) * f(midpoint, n, X) <= 0:
            a = midpoint
        else:
            b = midpoint
    return (a + b) / 2.0

def calculate_K(B, n, X):
    numerator = n
    denominator = (B + 1) * sum(X) - sum(i * X[i - 1] for i in range(1, n))
    K = numerator / denominator
    return K

def calculate_Xn1(n, B, K):
    return 1 / (K * (B - n))

def calculate_tk(n, B, K):
    tk = 0
    for i in range(1, int(B) - n):
        tk += 1 / i
    return (1 / K) * tk


resultB = bisection_method(f, a, b, tolerance, n, X)
print("Оценка максимального правдоподобия для B (метод бисекции):", round(resultB,4))
K = calculate_K(resultB, n, X)
print("Коэффициент пропорциональности K:", round(K,4))
Xn1 = calculate_Xn1(n, resultB, K)
print("Среднее время Xn+1:", round(Xn1,4))
tk = calculate_tk(n, resultB, K)
print("Время до окончания тестирования tk:", round(tk,4))