"# EAuction_Backend_Consumer" 
----
The objective of this service is to consume kafka messages from producer service and save it in mongoDB atlas in order to follow the cqrs pattern.
This service has been used in UI to retrieve data only.

Api's
----
Get the product details-->localhost:8093/product

Get the Buyer details of particular bid product-->localhost:8093/seller/show-bids/{productId}


