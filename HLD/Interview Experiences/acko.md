We are building a **Garage Information System** which is a master database of all the garages in India

We have identified the type of garages as per the Acko dictionary
Non-Network
Preferred 
Authorized service center
Acko Brand


**Functional Requirements**
We should be able to onboard 100 thousand garages into our system (100k)
We should be able to provide the location-based search functionality
I want to build a recommendation system based on the following criteria

Location (customer location)
type ( )
Cost (average cost of repair)
Rating (garages’ rating)
Repair time 


**Non Functional Requirements:**
Recommendation System → Based on eventual consistency! Always available to Recommend garages!
Every Garage - 10 vehicles a day! We have data about for Acko and preferred. ON Average 10k garage informations. 100k Recommendations per day. 


**→ 3 services**

Onboard Service!
Location-Based Search!
Recommendation System!


**Onboarding Service:**

**Core Apis**

POST : Garage location, name, information about the garage!
Persistence:
Cassandra DB  // we can use POSTGRESSQL

Search Service:
Core APIS 
GET : /listOfAllGarages
GET : /{location} → Lat and long , distance < 5kms , 
If we use postrges → geoHash ,Name, Type, ID


**Recommendation:**

Every garage can be given a rank → Against 



<img width="1499" alt="image" src="https://github.com/user-attachments/assets/750f2efc-17f8-4bb8-a9ac-6d29c30d2622" />


**Retrospectives:**
- We Can first of all solve problem and then think about scale! --> This is what he told! But its good to do it in reverse as well!
- We have to learn about recommendation systems! (Swiggy delivery partner how do they choose --> Based on geohash and location based services
is what he told --> Somewhere in the system we have to precompute it and not just we have to make api call every single time).
- Should learn about Location Based Services. Basically its like a proximity service in alex xu book. Also in bytebytego yt video.
- The choice of DB i told is cassandra --> Idk why i told this apart from any other nosql dbs like mongodb. (I told it as it will be suitable for
  distributed data store + used in write-heavy systems)
- I should Understand how to design a system design db schema and what fields to be included in that design! This is very important and also neeed to understand how to write query further!
