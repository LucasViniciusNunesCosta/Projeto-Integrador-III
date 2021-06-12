# Projeto-Integrador-III

## Banco de dados

```
CREATE DATABASE Xgeek;
USE Xgeek; 

CREATE TABLE Cliente (
  ID_Cliente INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  Nome VARCHAR(50),
  CPF VARCHAR(11) NOT NULL
);

CREATE TABLE Filial (
    ID_Flial INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Cidade VARCHAR(50) NOT NULL,
    Estado VARCHAR(2) NOT NULL,
    CEP VARCHAR(8) NOT NULL,
    Endereco VARCHAR(50) NOT NULL,
    Numero int NOT NULL,
    Complemento VARCHAR(150)
);

CREATE TABLE Estoque (
    ID_Estoque INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Nome VARCHAR(150) NOT NULL,
    Marca VARCHAR(50) NOT NULL,
    Categoria VARCHAR(50) NOT NULL,
    Quantidade INT NOT NULL,
    V_compra DECIMAL(9,2) NOT NULL,
    V_venda DECIMAL(9,2) NOT NULL,
    FK_Filial INT NOT NULL,
    FOREIGN KEY (FK_Filial) REFERENCES Filial (ID_Flial)
);

CREATE TABLE Funcionario (
    ID_Funcionario INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Nome VARCHAR(50) NOT NULL,
    Sobrenome VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Senha VARCHAR(200) NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    Atuacao VARCHAR(50) NOT NULL,
    Salario DECIMAL(20,2) NOT NULL,
    FK_Flial INT NOT NULL,
    FOREIGN KEY (FK_Flial) REFERENCES Filial (ID_Flial)
);

CREATE TABLE Compras (
    ID_Pedido INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Valor_total DECIMAL(20,2) NOT NULL,
    Data_Cri DATE NOT NULL,
    FK_Cliente INT NOT NULL,
    FK_Funcionario INT,
    FOREIGN KEY (FK_Cliente) REFERENCES Cliente (ID_Cliente),
    FOREIGN KEY (FK_Funcionario) REFERENCES Funcionario (ID_Funcionario)
);

CREATE TABLE Items (
    ID_Item INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    QTD INT NOT NULL,
    Desconto INT NOT NULL,
    V_Item DECIMAL(20,2),
    FK_Pedido INT NOT NULL,
    FK_Estoque INT NOT NULL,
    FOREIGN KEY (FK_Pedido) REFERENCES Compras(ID_Pedido),
    FOREIGN KEY (FK_Estoque) REFERENCES Estoque(ID_Estoque)
);

CREATE TABLE suporte (
    ID_suporte INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    topico VARCHAR(50) NOT NULL,
    assunto VARCHAR(50) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    referencia INT,
    resposta BOOLEAN NOT NULL,
    FK_Funcionario INT NOT NULL,
    FOREIGN KEY (FK_Funcionario) REFERENCES Funcionario (ID_Funcionario)
);

delimiter $$
create trigger BaixaEstoque after insert on item for each row
begin
update Estoque set Quantidade  = Quantidade-new.QTD where ID_Estoque = new.FK_Estoque;
update Compras set Valor_total = Valor_total+(new.Valor_Item*new.QTD_Item) where cod_P = new.fk_codP;
end $$
```
