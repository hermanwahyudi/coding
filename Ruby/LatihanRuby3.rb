input = gets.to_s
input.strip!
str = "Saya adalah mahasiswa Universitas Indonesia"
bool = 0
arr = str.split(" ")
for i in 0..arr.length-1 do 
	if arr[i] == input
		bool = 1
	end
	i+=1
end
if bool == 1
	puts "Ketemu!"
elsif 
	puts "Yah :("
end
