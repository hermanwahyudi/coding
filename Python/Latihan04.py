arr = ['h', 'e', 'r', 'm', 'a', 'n']
print(arr.index('h'))
for i in range(2, 10, 2):
	print(i)
str = "herman"[3:]
print(str)

s = "sdfs"+ "herman"

k = lambda x="8", u="0": x + u
print(k("","9"))

def sebuah_fungsi():
	str1 = "Her"
	f = lambda x: str1 + " " + x
	return f

act = sebuah_fungsi()
o = act("hh")
print(act)

#raise ValueError("Hai")

with open("file.txt") as file:
	for line in file:
		print(line)

def reverse(str):
	for idx in range(len(str)-1, -1, -1):
		yield str[idx]

for i in reverse("Her"):
	print(i)
