ALTER TABLE car
DROP COLUMN namee,
ADD COLUMN productionDate DATE, 
ADD COLUMN modelCar VARCHAR (10) NOT NULL 
    CHECK (
        modelCar = 'AUDI' OR
        modelCar = 'BMW' OR
        modelCar = 'FIAT'
    ),
ADD COLUMN typeCar VARCHAR (10) NOT NULL 
    CHECK (
        typeCar = 'COMBI' OR 
        typeCar = 'CABRIO' OR 
        typeCar = 'SEDAN'
    );