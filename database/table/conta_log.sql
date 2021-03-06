
  CREATE TABLE dev.CONTA_LOG
   (	"NUMERO" NUMBER NOT NULL ENABLE,
	"SALDO_ANTERIOR" NUMBER(10,2),
	"NOVO_SALDO" NUMBER(10,2) NOT NULL ENABLE,
	"TIPO_MOVIMENTACAO" VARCHAR2(20 BYTE) NOT NULL ENABLE,
	"DIFERENCA_SALDO" NUMBER,
	 CONSTRAINT CONTA_LOG_FK FOREIGN KEY ("NUMERO")
	  REFERENCES dev.CONTA ("NUMERO") ENABLE
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

