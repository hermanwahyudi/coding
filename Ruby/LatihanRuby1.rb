input = ARGV[0].to_i

i = 0
arr = []
while i <= 10
	if i%2 == 0
		puts "#{i} Genap"
		if i == 2
			puts "#{i}"
		end
	elsif
		puts "#{i} Ganjil"
	end	
	arr[i] = i
	i+=1
end
puts arr



def recursion(param1)
	return param1
end 

puts recursion(1)

str = "Herman"
for i in 0..str.length-1 do 
	puts str[i]
end