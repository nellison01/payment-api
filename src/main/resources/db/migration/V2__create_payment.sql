/* Db setup first time the api is run */


/* Create payment table */
CREATE TABLE PAYMENT(
  ID VARCHAR(255) PRIMARY KEY,
  TYPE INT,
  VERSION INT,
  ORG_ID VARCHAR(255),

  AMOUNT DOUBLE,
  CURRENCY VARCHAR(255),
  PROCESSING_DATE VARCHAR(255)
);

/* Insert dummy data to payment table */
INSERT INTO PAYMENT VALUES('93cbad63-4bee-406e-9edd-d49d37c9799b', 0, 1, 'e3a4c7d1-c4ce-4284-9fb0-c677210df41f', 101.01, 'GBP', '04/01/2018');
INSERT INTO PAYMENT VALUES('cc0140fb-a43d-43c1-bee2-e5025ccb4043', 0, 1, 'e3a4c7d1-c4ce-4284-9fb0-c677210df41f', 56.63, 'GBP', '04/01/2018');
INSERT INTO PAYMENT VALUES('f7ff63ea-dd73-4a82-acd1-759d07eaea0f', 0, 1, 'bbee6fbf-7d4b-4b75-8c04-2666e1ad2eee', 20000, 'USD', '04/01/2018');