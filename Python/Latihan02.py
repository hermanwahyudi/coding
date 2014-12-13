import re, os

class Latihan02:
	def __init__(self):
		return None
	def countChar(self, str01):
		self.set01 = set(str01) # set
		self.set02 = {"key1":"value1", "key2":"value2"} # Dict, mirip kayak HashMap
		counter, j = 0, 0
		for item in self.set01:
			for i in str01:
				if item == i:
					counter += 1
			print(item, counter)
			counter = 0
	def matchStr(self, str01):
		regexp = re.compile(str01)
		count = 0
		file = open("file.txt", "r")
		for line in file.readlines():
			if regexp.search(line):
				count += 1
		file.close()
		print(count)	

	def functOS(self):
		print(os.getcwd(), dir())

	def functBool(self):
		y = False * 2
		print(y)

	def __str__(self):
		return "Hallo"

# main

if(__name__ == "__main__"):
	str01 = input("Masukan : ")
	obj = Latihan02()
	obj.countChar(str01)

	obj.matchStr(str01)
	obj.functOS()
	obj.functBool()
	print("j, k g".split(","))
	print(obj)