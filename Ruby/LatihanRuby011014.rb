print "Hello, Ruby!".upcase
print "\n"

a = 9
b = 8
puts "#{a} + #{b} = #{a+b}"

str01 = "a"
str02 = "b"
nilai = str01 <=> str02
puts "Hai" if !(nilai == 1)

i = 1
j = 0
while i <= 12
	k = 0
	while j < 12
		k = k + i
		puts k
		j += 1
	end
puts "\n"
i += 1
end