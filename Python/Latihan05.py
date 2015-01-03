import re

regexp = re.compile("([a-z])[^0-8]\.*")
if regexp.match("a9"):
	print("Yap")
	
