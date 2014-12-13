from collections import deque

# class Latihan01

class Latihan01:
	arr = [2, 6, 3, 7, 1, 4]
	def __init__(self):
		return None
	def search(self, x):
		for i in range(len(Latihan01.arr)):
			if Latihan01.arr[i] == x:
				return str(x) + " is in index " + str(Latihan01.arr.index(x)) 
		return "Tidak ada!"
	def horizontakPrint(self):
		i = 0
		while i < len(Latihan01.arr):
			if i != len(Latihan01.arr)-1:
				print(Latihan01.arr[i] **2, end=', ')
			elif i == len(Latihan01.arr)-1:
				print(Latihan01.arr[i]**2, end=' ')
			i += 1
		print()
	def fibonacci(self, N):
		self.fib = [0, 1]
		for i in range(2, 10):
			self.fib.append(self.fib[i-2]+self.fib[i-1])
		return self.fib
	def __str__(self):
		return "Ini kelas Latihan01"
			
# main

obj = Latihan01()
print(obj.search(4))
obj.horizontakPrint()
print(obj.fibonacci(9))	
obj.fib.pop()
print(obj.fib)	
obj.fib.insert(4, 4)
print(obj.fib)	

queue = deque(obj.fib)
queue.popleft()
print(queue)	

del obj.fib[0:2]
print(obj.fib)

str2 = "jik" "lk"
print(str2[1:2])

str4 = "ooo", "kkkk", 8989
str5 = str4, (8, 5, 0)
print(str4, str5)

setExample = {"trt", "khk", "hghg", "trt"}
print(setExample)
print("jhj" in setExample)
setExample01 = set("heeeejkj")
setExample02 = set("rhr")
print("hk" in setExample01, setExample01 ^ setExample02, setExample01 & setExample02)

bool = True
print(not bool)

dictExample = {"key1":"value1", "key2":"value2"}
for k, v in dictExample.items():
	print(k, v)
for i in range(10, 0, -2):
	print(i)
