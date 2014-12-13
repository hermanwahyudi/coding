class Ayah:
	def __init__(self, nama):
		self.nama = nama
	def getNama(self):
		return self.nama
	def hoy(self):
		print("hoy")
class Anak(Ayah):
	def __init__(self, nama, namaAyah):
		self.nama = nama
		self.namaAyah = namaAyah
	def getNama(self):
		return self.nama
	def getNamaAyah(self):
		return self.namaAyah

ayah = Ayah("Andi")
print(ayah.getNama())
anak = Anak("Ayu", ayah.getNama())
print(anak.getNama(), anak.getNamaAyah())
anak.hoy()