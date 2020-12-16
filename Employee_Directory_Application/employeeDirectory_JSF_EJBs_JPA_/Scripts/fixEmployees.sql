-- ensure all EMPLOYEE ROWS have CREATED_DATE, UPDATED_DATE and VERSION SET
ALTER TABLE EMPLOYEE ADD VERSION INTEGER DEFAULT 1;
UPDATE EMPLOYEE SET CREATED_DATE=CURRENT_TIMESTAMP, UPDATED_DATE=CURRENT_TIMESTAMP;