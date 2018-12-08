
# coding: utf-8

# # Scraping Rate My Professors

# In[29]:


import requests
import json
import math


# In[26]:


class rmpScraper:
    def __init__(self, sch_id):
        self.sid = sch_id
        self.list = self.createlist()
        self.index = False

    def createlist(self):
        proflist = []
        n = self.numProfs(self.sid)
        num = math.ceil(n/20)
        i = 1
        while (i <= num):
            page = requests.get("http://www.ratemyprofessors.com/filter/professor/?&page=" + str(
                i) + "&filter=teacherlastname_sort_s+asc&query=*%3A*&queryoption=TEACHER&queryBy=schoolId&sid=" + str(
                self.sid))
            jsonpage = json.loads(page.content)
            temp = jsonpage['professors']
            proflist.extend(temp)
            i += 1
        return proflist

    def numProfs(self,id):
        page = requests.get(
            "http://www.ratemyprofessors.com/filter/professor/?&page=1&filter=teacherlastname_sort_s+asc&query=*%3A*&queryoption=TEACHER&queryBy=schoolId&sid=" + str(
                id))  
        jsonpage = json.loads(page.content)
        num = jsonpage['remaining'] + 20
        return num

    def printProfessors(self): 
        for i in range(0, len(self.list)):
            print(self.list[i]['tFname'] + " " + self.list[i]['tLname'])
            print("Department: " + self.list[i]["tDept"])
            print("Rating: " + self.list[i]["overall_rating"] + " " + "(" + self.list[i]["rating_class"] + ")" + "\n")


# In[27]:


UT = rmpScraper(1255)
UT.printProfessors()

