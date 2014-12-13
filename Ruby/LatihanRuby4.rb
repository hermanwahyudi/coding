search = ARGV[0]
dir = ARGV[1]
if search != nil && dir != nil 
	if(!File.directory?(dir))
		puts "Direktori '#{dir}/' tidak ada!"
	elsif 
		arr = Dir.entries("#{dir}/.")
		if arr.length-2 != 0
			arr01 = []
			k = 0
			for i in 2..arr.length-1 do 
				file = File.open("#{dir}/#{arr[i]}")
					file.each do |line|
						s = line.split(" ")
						for j in 0..s.length-1 do 
							if (s[j] == search)
								arr01[k] = arr[i].split(".")[0]
								k +=1
								break
							end
						end
					end unless file.closed?
				file.close
			end
			if arr01.size == 0
				puts "Term '#{search}' tidak ditemukan di direktori '#{dir}/'!"
			else
				puts "Term '#{search}' ditemukan dalam file:"
				arr01.each do |g|
					puts g
				end
			end
		else 
			puts "Tidak ada file di direktori '#{dir}/'"
		end
	end
else 
	puts "Kata yg dicari dan Nama Direktori harus diisi!"
end