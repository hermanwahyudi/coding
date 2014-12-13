a = ['cat', 'doggy']
for i in a:
	print(i, len(i))
b = [1, 6, 3, 2, 9]
print(b.index(1))
print(b.count(1))
a.reverse()
print(a)
a.sort()
print(a)

i, j = 9, 8
print(i//j)
temp = "Herman"  "Wahyudi"
print(temp*4)
print(temp[1])
print(temp[1:4])
print(temp[2:])

def isPrime(N):
	for i in range(2, N):
		if N%i == 0:
			return False
	return True

def listOddEven():
	i = 0
	while i < 10:
		if i%2 == 0:
			print(i, "Genap")
		else:
			print(i, "Ganjil")
		i += 1

def primeList():
	for i in range(3, 10):
		for j in range(2, i):
			if i%j == 0:
				print(i, "Not")
				break
		else:
			print(i, "Prima")
def f(a, L=[]):
	L.append(a)
	return L

listOddEven()
primeList()
print(isPrime(7))
f(1) 
f(2) 
f(3)
print(f(4))

class Kalkulator:
	str1 = ""
	def __init__(self):
		self.A = 0
		self.B = 
	def setTambah(self, x, y):
		self.A = x
		self.B = y
	def getTambah(self):
		return self.A + self.B
	def loopStr():
		strl = "Herman"
		str2 = ""
		for i in strl:
			str2 += i 
		return str2

obj = Kalkulator()
x = int(input("Bil 1: "))
y = int(input("Bil 2: "))
obj.setTambah(x, y)
print(obj.A, "+", obj.B, "=", obj.getTambah())
Kalkulator.str1 = "j"
print(Kalkulator.str1)
print(Kalkulator.loopStr())

