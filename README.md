# requirements to run this project

## local

requirements:
[uv](https://docs.astral.sh/uv/) for Python package and environment management.


- install python3.12 using uv:
```bash
uv python install cpython-3.12-linux-x86_64-gnu
```

- create virtual environment:
```bash
uv venv
```

- activate virtual environment:
```bash
source .venv/bin/activate
```

- install dependencies:
```bash
uv sync --all-groups
```

- run the project:
```bash
fastapi dev
```

## run the project inside docker containers
requirements:
- docker
- docker-compose

```bash
docker-compose up --build
```
Access : <br>
API at: http://0.0.0.0:8000/ <br>
Swagger UI at: http://0.0.0.0:8000/docs <br>
pgadmin at: http://localhost:15432/ <br>

inside pgadmin:
- to login:<br>
    - email: admin@admin.com<br>
    - password: password<br>
- to connect to database:<br>
    - add new server (name can be whatever name) -> connection tab: <br>
        - host: database<br>
        - username: admin<br>
        - password: password<br>
