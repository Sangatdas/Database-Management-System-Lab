from pymongo import MongoClient



client = MongoClient(host='localhost',port=27017)

db = client.student

name = input("Name of student: ")
rollno = input("Roll no. : ")
marks = input("Marks: ")

stud = {'Name':name,'Roll_no':rollno,'Marks':marks}

collection = db.Students

insert_id = collection.insert_one(stud)

print(insert_id)

rollno = input("Enter Roll no. whose data is to be updated")
#field = input("Enter field to be updated")
val = input("Enter new value")

collection.update_one({'Roll_no':rollno},{'$set':{'Name':val}})

rollno = input("Enter Roll no. of student to be deleted")
collection.delete_one({'Roll_no':rollno})
