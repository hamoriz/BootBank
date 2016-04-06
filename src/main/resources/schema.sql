CREATE SEQUENCE IF NOT EXISTS PUBLIC.SYSTEM_SEQUENCE_8009191C_29AA_44D8_9064_0E60A83310A5 START WITH 26 BELONGS_TO_TABLE;
CREATE SEQUENCE IF NOT EXISTS PUBLIC.SYSTEM_SEQUENCE_02BFC56E_CD8B_427F_96B0_FE0ADB0752B6 START WITH 28 BELONGS_TO_TABLE;
CREATE SEQUENCE IF NOT EXISTS PUBLIC.SYSTEM_SEQUENCE_3EBB7777_1209_4DCA_9C49_7F9D40658F04 START WITH 3 BELONGS_TO_TABLE;
CREATE SEQUENCE IF NOT EXISTS PUBLIC.SYSTEM_SEQUENCE_FDC9F5B4_F5C9_4096_96FC_668A12FBAF25 START WITH 69 BELONGS_TO_TABLE;

CREATE CACHED TABLE CUSTOMER(
    ID BIGINT DEFAULT (NEXT VALUE FOR SYSTEM_SEQUENCE_FDC9F5B4_F5C9_4096_96FC_668A12FBAF25) NOT NULL NULL_TO_DEFAULT SEQUENCE SYSTEM_SEQUENCE_FDC9F5B4_F5C9_4096_96FC_668A12FBAF25,
    NAME VARCHAR(255)
);
ALTER TABLE CUSTOMER ADD CONSTRAINT CONSTRAINT_9 PRIMARY KEY(ID);

CREATE CACHED TABLE ACCOUNT_TYPE(
    ID BIGINT DEFAULT (NEXT VALUE FOR SYSTEM_SEQUENCE_3EBB7777_1209_4DCA_9C49_7F9D40658F04) NOT NULL NULL_TO_DEFAULT SEQUENCE SYSTEM_SEQUENCE_3EBB7777_1209_4DCA_9C49_7F9D40658F04,
    NAME VARCHAR(255)
);


CREATE CACHED TABLE ACCOUNT(
    ID BIGINT DEFAULT (NEXT VALUE FOR SYSTEM_SEQUENCE_3EBB7777_1209_4DCA_9C49_7F9D40658F04) NOT NULL NULL_TO_DEFAULT SEQUENCE SYSTEM_SEQUENCE_3EBB7777_1209_4DCA_9C49_7F9D40658F04,
    BALANCE BIGINT,
    CUSTOMER_ID BIGINT,
    ACCOUNT_TYPE_ID BIGINT
);


ALTER TABLE ACCOUNT ADD CONSTRAINT CONSTRAINT_1 PRIMARY KEY(ID);


ALTER TABLE ACCOUNT ADD CONSTRAINT FK946977F11E8FDB8 FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(ID) NOCHECK;
ALTER TABLE ACCOUNT ADD CONSTRAINT FK946977F11E8FDB9 FOREIGN KEY(ACCOUNT_TYPE_ID) REFERENCES ACCOUNT_TYPE(ID) NOCHECK;


INSERT INTO ACCOUNT_TYPE (ID,NAME) VALUES (1,'Current');
INSERT INTO ACCOUNT_TYPE (ID,NAME) VALUES (2,'Saving');
INSERT INTO ACCOUNT_TYPE (ID,NAME) VALUES (3,'CashIsa');
commit;



