CREATE TABLE bookings (
  booking_ref INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 957000000, INCREMENT BY 1) PRIMARY KEY,
  container_size INTEGER,
  container_type  VARCHAR(255) DEFAULT 'DRY',
  origin VARCHAR(20),
  destination VARCHAR(20),
  quantity INTEGER,
  timestamp VARCHAR(140)
);

INSERT INTO bookings (container_size,container_type, origin, destination, quantity, timestamp) VALUES (20,'DRY','Southampton','Singapore',5,'2020-10-12T13:53:09Z');
INSERT INTO bookings (container_size,container_type, origin, destination, quantity, timestamp) VALUES (10,'DRY','Brazil','India',2,'2020-11-12T13:53:09Z');
INSERT INTO bookings (container_size,container_type, origin, destination, quantity, timestamp) VALUES (12,'REEFER','Pakistan','Dubai',3,'2021-01-12T13:53:09Z');
INSERT INTO bookings (container_size,container_type, origin, destination, quantity, timestamp) VALUES (11,'DRY','USA','UK',6,'2020-01-12T13:53:09Z');
INSERT INTO bookings (container_size,container_type, origin, destination, quantity, timestamp) VALUES (44,'REEFER','Saudi','Ireland',2,'2021-10-12T13:53:09Z');