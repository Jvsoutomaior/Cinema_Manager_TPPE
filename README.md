# requirements to run this project

* [uv](https://docs.astral.sh/uv/) for Python package and environment management.

Fist install uv

Then install python3.13.3 using uv:
```bash
uv python download cpython-3.13.3-linux-x86_64-gnu
```

Then create and activate virtual environment:
```bash
uv venv
source venv/bin/activate
```

Then install dependencies:
```bash
uv sync
```

Then run the project:
```bash
cd app
uvicorn main:app
```

to run tests:
```bash
pytest
```