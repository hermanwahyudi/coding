class Mahasiswa
	def initialize(nama, umur)
		@nama = nama
		@umur = umur
	end
	def get
		puts "Nama : #{@nama}"
	end
	def nama=(nama)
		@nama = nama
	end
end

mahasiswa = Mahasiswa.new("Herman", 20)
mahasiswa.get
mahasiswa.nama = "Andi"
mahasiswa.get