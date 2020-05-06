## Resources URL examples

### List of customers
---
#### Request

`GET /customers`

#### Response

    Status: 200 OK

    [{
        "id": 1,
        "name": "Heron",
        "phone": "61 9999-5555",
        "email": "heron@email.com"
    }, {
        "id": 2,
        "name": "Debora Amorim",
        "phone": "61 5555-6666",
        "email": "debs@email.com"
    }]

<br>

### Register a new custumer
---
#### Request

`POST /customers`

    {
	    "name": "Maria",
	    "email": "maria@email.com",
	    "phone": "21 22221-5246"
    }

#### Response

New customer:

    Status: 201 Created

    {
        "id": 3,
        "name": "Maria",
        "phone": "21 22221-5246",
        "email": "maria@email.com"
    }

Existing email:

    Status: 400 Bad Request

    {
        "status": 400,
        "dateTime": "2020-05-05T22:16:00.426-03:00",
        "title": "E-mail já cadastrado."
    }

<br>

### Get customer by id
---
#### Request

`GET /customers/{customerId}`

#### Response

Customer that is registered:

    Status: 200 OK

    {
        "id": 2,
        "name": "Debora Amorim",
        "phone": "61 5555-6666",
        "email": "debs@email.com"
    }

Get non-existent customer:

    Status: 404 Not Found

<br>

### Update customer
---
#### Request

`PUT /customers/{customerId}`

    {
        "name": "Debora",
        "phone": "61 5555-6666",
        "email": "debs@email.com"
    }

#### Response

Update success:

    Status: 200 OK

    {
        "id": 2,
        "name": "Debora",
        "phone": "61 5555-6666",
        "email": "debs@email.com"
    }

Bad format request:

    Status: 400 Bad Request

    {
        "status": 400,
        "dateTime": "2020-05-05T22:31:32.612-03:00",
        "title": "Um ou mais campos estão inválidos. Tente novamente.",
        "inputs": [
            {
                "name": "name",
                "message": "É obrigatório"
            },
            {
                "name": "email",
                "message": "É obrigatório",
                "message": "Deve ser um e-mail válido"
            },
            {
                "name": "phone",
                "message": "É obrigatório",
                "message": "Deve ter no mínimo 0 e no máximo 15 caracteres"
            }
        ]
    }

<br>

### Create service order
---
#### Request

`POST /service-order`

    {
        "customer": {
            "id": 2
        },
        "description": "Troca de tela do celular.",
        "price": 250
    }

#### Response

Create success:

    Status: 201 Created

    {
        "id": 1,
        "customer": {
            "id": 2,
            "name": "Debora",
            "phone": "61 5555-6666",
            "email": "debs@email.com"
        },
        "description": "Troca de tela do celular.",
        "price": 250,
        "status": "ABERTA",
        "openingDate": "2020-05-05T22:36:42.248-03:00",
        "closingDate": null
    }

Bad format request:

    Status: 400 Bad Request

    {
        "status": 400,
        "dateTime": "2020-05-05T22:41:28.676-03:00",
        "title": "Um ou mais campos estão inválidos. Tente novamente.",
        "inputs": [
            {
                "name": "description",
                "message": "É obrigatório"
            },
            {
                "name": "customer",
                "message": "É obrigatório"
            },
            {
                "name": "price",
                "message": "É obrigatório"
            }
        ]
    }

Non-existent customer:

    Status: 400 Bad Request

    {
        "status": 400,
        "dateTime": "2020-05-05T22:48:00.933-03:00",
        "title": "Cliente não encontrado."
    }