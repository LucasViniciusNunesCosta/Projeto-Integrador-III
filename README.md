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
    Quantidade VARCHAR(50) NOT NULL,
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
    CPF VARCHAR(11) NOT NULL,
    Atuacao VARCHAR(50) NOT NULL,
    Salario DECIMAL(20,2) NOT NULL,
	Login varchar(30) NOT NULL,
    Senha varchar(30) NOT NULL,
    FK_Flial INT NOT NULL,
    FOREIGN KEY (FK_Flial) REFERENCES Filial (ID_Flial)
);

CREATE TABLE Vendas (
    ID_Pedido INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Valor_total DECIMAL(20,2) NOT NULL,
    Data_Cri DATE NOT NULL,
    Nome_Produto varchar(30) NOT NULL,
    FK_Cliente INT NOT NULL,
    FK_Funcionario INT,
    FOREIGN KEY (FK_Cliente) REFERENCES Cliente (ID_Cliente),
    FOREIGN KEY (FK_Funcionario) REFERENCES Funcionario (ID_Funcionario)
);

CREATE TABLE Items (
    ID_Item INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    QTD INT NOT NULL,
    Desconto DECIMAL(2,2) NOT NULL,
    FK_Pedido INT NOT NULL,
    FK_Estoque INT NOT NULL,
    FOREIGN KEY (FK_Pedido) REFERENCES Vendas(ID_Pedido),
    FOREIGN KEY (FK_Estoque) REFERENCES Estoque(ID_Estoque)
);

SELECT Cliente.ID_Cliente, Cliente.Nome, Cliente.CPF, SUM(Vendas.Valor_total) AS "Valor tutal" from Cliente
	INNER JOIN Vendas ON Cliente.ID_Cliente = Vendas.FK_Cliente
    WHERE Vendas.Data_Cri BETWEEN '2020/10/01' AND '2020/11/30' GROUP BY Cliente.ID_Cliente;
```
