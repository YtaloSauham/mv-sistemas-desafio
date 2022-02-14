
CREATE TABLE dev.CLIENTE_PF
(	"CPF" NUMBER(*,0) NOT NULL ENABLE,
     "NOME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
     "SOBRENOME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
     CONSTRAINT CLIENTE_PF_PK PRIMARY KEY ("CPF")
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
         STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
         PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
         TABLESPACE "SYSTEM"  ENABLE,
     CONSTRAINT CLIENTE_PF_FK FOREIGN KEY ("CPF")
         REFERENCES dev.CLIENTE ("ID_CLIENTE") ON DELETE CASCADE ENABLE
) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
