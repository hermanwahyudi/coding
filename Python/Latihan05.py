import re


pattern = "^(her|man)"
regexp = re.compile(pattern)

if regexp.match("herf"):
	print("Yap")

pattern = "[a-s]{2,3}"
regexp = re.compile(pattern)

if regexp.match("asahb"):
	print("Ok")

email_pattern = "^[a-z0-9]+(\.?[a-z0-9]+?){1,2}@[a-z]+(\.[a-z]+?)"
r = re.compile(email_pattern)

if(r.match(".k.k@jj.co.cc")):
	print("Email OK")		
	
