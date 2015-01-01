import re

regexp = re.compile("h|j")
if regexp.match("h"):
	print("Yap")