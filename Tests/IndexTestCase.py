from selenium.webdriver import Chrome
import time

path = "/usr/local/bin/chromedriver"
driver = Chrome(executable_path=path)
driver.get("localhost:8080/index.jsp")

driver.maximize_window()

# Test Professors link
time.sleep(2)
driver.find_element_by_name("url_professors").click()

assert driver.current_url == "http://localhost:8080/professors.jsp"

time.sleep(2)
driver.get("localhost:8080/index.jsp")

# Test Courses link
time.sleep(2)
driver.find_element_by_name("url_courses").click()

assert driver.current_url == "http://localhost:8080/courses.jsp"

time.sleep(2)
driver.get("localhost:8080/index.jsp")

# Test Schedule link
time.sleep(2)
driver.find_element_by_name("url_schedule").click()

assert driver.current_url == "http://localhost:8080/schedule.jsp"

time.sleep(2)
driver.get("localhost:8080/index.jsp")

# Test Index logo link
time.sleep(2)
driver.find_element_by_name("url_logo_index").click()

assert driver.current_url == "http://localhost:8080/index.jsp"

time.sleep(2)
