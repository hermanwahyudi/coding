import sys

class Latihan06:

	def __init__(self):
		return None
	
	def solve_1(self):
		pasukan1 = input().split(" ")
		pasukan2 = input().split(" ")
		point1 = int(pasukan1[0])*3 + int(pasukan1[1])*2 + int(pasukan1[2])
		point2 = int(pasukan2[0])*3 + int(pasukan2[1])*2 + int(pasukan2[2])
		if(point1 > point2):
			print("A")
		elif(point1 < point2):
			print("B")
		else:
			print("SERI")

	def is_palindrome(self, x=""):
		length = len(x)-1
		start, end = 0, length
		is_palindrome = True
		while start < length/2 and is_palindrome:
			if x[start] == x[end]:
				start += 1
				end -= 1
			else:
				is_palindrome = False
		if is_palindrome:
			return "PALINDROME"
		return "NOT PALINDROME"


if(__name__ == "__main__"):
	o = Latihan06()
	o.solve_1()
	print(o.is_palindrome("kasurusak"))
		