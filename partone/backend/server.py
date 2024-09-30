from fastapi import FastAPI

app = FastAPI()

@app.get("/api/data")
async def sendJson():
    return {
        "superhero": "constantine",
        "enemy": "clayface"
    }
    