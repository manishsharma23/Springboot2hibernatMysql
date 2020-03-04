Elastic search details
--------------------------------
post urt : 
http://localhost:9200/profile/
---------------------------------------------------------
body :

  "mappings":{
      "properties":{
				"id":{ "type":"text"},
        "firstname": { "type":"text"},
				"lastname": { "type":"text"},
				"emails":{ "type":"text"},
				"yearsOfExperience":{"type":"text"},
				"technologies":{ "type":"nested"}
      }
   }
 
}
--------------------------------------------------------------

url for micro service
GET : http://localhost:8080/getall

--------------------------------------------------------------
GET : http://localhost:8080/search?technology=oracle

--------------------------------------------------------------

Get : http://localhost:8080/api/v1/profiles/8b924d8a-f52c-4685-bc3e-b28f2dcdca47

--------------------------------------------------------------
DELET : http://localhost:8080/api/v1/profiles/c6396774-6407-4672-a084-ec14b0743445

--------------------------------------------------------------
POST : http://localhost:8080/api/v1/profiles
{
  "firstName":"lisha",
	"lastName":"sharma",
	"emails":"sdsds@sadfdsfa.com",
  "technologies":[
		{
		"name" :"writing",
			"yearsOfExperience":"one yrs"
		}
		,
		{			
			"name" :"reading",
			"yearsOfExperience":"two yrs"
		}
	]
	}
	
--------------------------------------------------------------
Put : http://localhost:8080/api/v1/profiles/a1551b0b-5ae8-4fe7-b3d5-38b8a53d53d5
body : 

  {
    "id": "a1551b0b-5ae8-4fe7-b3d5-38b8a53d53d5",
    "firstName": "updatefl",
    "lastName": "updateln",
    "technologies": [
      {
        "name": "study",
        "yearsOfExperience": "nine"
      },
      {
        "name": "oracle",
        "yearsOfExperience": "ten"
      }
    ],
    "emails": "asdasd@asds.co.in",
    "yearsOfExperience": "99"
}