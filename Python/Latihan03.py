import re

class Latihan03:
	def __init__(self):
		return None
	def toBinary(self, input1):
		sisa, hasilBagi = "", 0
		while(input1 != 0):
			hasilBagi = int(input1/2)
			sisa = str(input1%2) + sisa
			input1 = hasilBagi
		return sisa
	def __str__(self):
		return "Ini kelas Latihan03"


# main
if(__name__ == "__main__"):
	obj = Latihan03()
	input1 = input("Masukan angka : ")
	
	print(obj.toBinary(int(input1)))
	print("hello")