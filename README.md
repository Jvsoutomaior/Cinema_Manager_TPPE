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
uv sync
```

- run the project:
```bash
fastapi dev
```

## docker
requirements:
- docker

```
docker build -t app .
```

Then run the project:
```bash
docker run -p 8000:8000 app
```

## docker-compose
requirements:
- docker
- docker-compose

```bash
docker-compose up
```
Access
http://localhost:15432