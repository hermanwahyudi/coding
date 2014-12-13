from selenium import webdriver

browser = webdriver.Firefox()

browser.get('https://tokopedia.com/')

browser.find_element_by_link_text("Masuk").click()