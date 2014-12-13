locator = {"last_name":"name=lastName",
			"search":"id=search"
		}
st = locator['search']
st01 = st[:st.index("=")]

from selenium.webdriver.common.by import By

print(By.LINK_TEXT)

sty = "Herman Wahyudi"
print(sty[3:])
print(sty.replace("He", "Jo"))

for i, j in locator.items():
	print(i, j)
i, j, k = 0, 9, 0
if(i == j):
	print("L")
else:
	print("k") 
s = ""
if(not s):
	print("Kosong")
ar = [['']*3]*4
for i in range(3):
	for j in range(3):
		ar[i][j] = i+j
print(ar[0][1])

class Test:
	def yours(self, move):
		self.dead, self.fail = 100, True
		while move < self.dead:
			if self.fail == True:
				print("Allah is always your side")
				move += 1
		return move

# main

Test().yours(0)