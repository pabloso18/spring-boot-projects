# Spring Hateoas

I will show an example to add ***HATEOAS*** links to existing REST APIs created in a spring boot project.

On this repository, I use spring boot, hateoas 1.+, H2 Database.

The main purpose of ***HATEOAS*** is to provide extra information in REST API response. This help to get additional endpoint details from a single call.

On this example:

``http://localhost:8080/hotels/v1/``

From a normal response like this
```
{
    "id": "7dabcba6-32ac-434f-bd4d-effa54006638",
    "name": "Cartago",
    "country": "CR",
    "address": "Cartago",
    "phone": "2552-2222",
    "zipCode": "3301"
}
```
To this:

```
    {
        "id": "7dabcba6-32ac-434f-bd4d-effa54006638",
        "name": "Cartago",
        "country": "CR",
        "address": "Cartago",
        "phone": "2552-2222",
        "zipCode": "3301",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/hotels/v1/7dabcba6-32ac-434f-bd4d-effa54006638"
            },
            {
                "rel": "Delete",
                "href": "http://localhost:8080/hotels/v1/7dabcba6-32ac-434f-bd4d-effa54006638"
            }
        ]
    }
```
