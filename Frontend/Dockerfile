# 1. Használjunk Node.js alap image-t
FROM node:20-alpine
LABEL authors="Méhes Nándor"

# 2. Munkakönyvtár létrehozása és beállítása a konténeren belül
WORKDIR /usr/src/app

# 3. Fájlok másolása
COPY ./frontend ./

# 4. Függőségek telepítése
RUN npm install

# 5. A Vite dev szerver futtatása (alapértelmezett port: 5173)
EXPOSE 5173
CMD ["npm", "run", "dev"]