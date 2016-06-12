-- =================================================
-- Autor:			Gerimar Perez, Miguel Flores, Royer Chavez
-- Fecha:			12/06/2016
-- Descripción:		Examen
-- Versión:			1.6.0
-- =================================================

------------------------------------- Soy Una Barra Separadora  :) ----------------------------------------
PRINT 'INICIANDO CREACION DE LA BASE DE DATOS'

USE master;
GO
IF EXISTS(SELECT name FROM sys.databases WHERE name = 'examen')
	DROP DATABASE examen
GO

IF NOT EXISTS(SELECT name FROM sys.databases WHERE name = 'examen')
	CREATE DATABASE examen;
GO 

USE [examen]
GO

PRINT 'FINALIZANDO LA  CREACION DE LA BASE DE DATOS'
/****** Object:  StoredProcedure [dbo].[sp_CategoriaDelete]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_CategoriaDelete]
(
	@id_categoria int
)

AS

SET NOCOUNT ON

DELETE FROM [Categoria]
WHERE [id_categoria] = @id_categoria

GO
/****** Object:  StoredProcedure [dbo].[sp_CategoriaInsert]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_CategoriaInsert]
(
	@nombre_categoria varchar(50),
	@tipo_categoria varchar(50)
)

AS

SET NOCOUNT ON

INSERT INTO [Categoria]
(
	[nombre_categoria],
	[tipo_categoria]
)
VALUES
(
	@nombre_categoria,
	@tipo_categoria
)

SELECT CAST(scope_identity() AS int)

GO
/****** Object:  StoredProcedure [dbo].[sp_CategoriaSelect]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_CategoriaSelect]
(
	@id_categoria int
)

AS

SET NOCOUNT ON

SELECT [id_categoria],
	[nombre_categoria],
	[tipo_categoria]
FROM [Categoria]
WHERE [id_categoria] = @id_categoria

GO
/****** Object:  StoredProcedure [dbo].[sp_CategoriaSelectAll]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_CategoriaSelectAll]

AS

SET NOCOUNT ON

SELECT [id_categoria],
	[nombre_categoria],
	[tipo_categoria]
FROM [Categoria]

GO
/****** Object:  StoredProcedure [dbo].[sp_CategoriaUpdate]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_CategoriaUpdate]
(
	@id_categoria int,
	@nombre_categoria varchar(50),
	@tipo_categoria varchar(50)
)

AS

SET NOCOUNT ON

UPDATE [Categoria]
SET [nombre_categoria] = @nombre_categoria,
	[tipo_categoria] = @tipo_categoria
WHERE [id_categoria] = @id_categoria

GO
/****** Object:  StoredProcedure [dbo].[sp_cuentaDelete]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_cuentaDelete]
(
	@id_cuenta int
)

AS

SET NOCOUNT ON

DELETE FROM [cuenta]
WHERE [id_cuenta] = @id_cuenta

GO
/****** Object:  StoredProcedure [dbo].[sp_cuentaInsert]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_cuentaInsert]
(
	@nombre_cuenta varchar(50),
	@saldo_inicial float(53)
)

AS

SET NOCOUNT ON

INSERT INTO [cuenta]
(
	[nombre_cuenta],
	[saldo_inicial]
)
VALUES
(
	@nombre_cuenta,
	@saldo_inicial
)

SELECT CAST(scope_identity() AS int)

GO
/****** Object:  StoredProcedure [dbo].[sp_cuentaSelect]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_cuentaSelect]
(
	@id_cuenta int
)

AS

SET NOCOUNT ON

SELECT [id_cuenta],
	[nombre_cuenta],
	[saldo_inicial]
FROM [cuenta]
WHERE [id_cuenta] = @id_cuenta

GO
/****** Object:  StoredProcedure [dbo].[sp_cuentaSelectAll]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_cuentaSelectAll]

AS

SET NOCOUNT ON

SELECT [id_cuenta],
	[nombre_cuenta],
	[saldo_inicial]
FROM [cuenta]

GO
/****** Object:  StoredProcedure [dbo].[sp_cuentaUpdate]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_cuentaUpdate]
(
	@id_cuenta int,
	@nombre_cuenta varchar(50),
	@saldo_inicial float(53)
)

AS

SET NOCOUNT ON

UPDATE [cuenta]
SET [nombre_cuenta] = @nombre_cuenta,
	[saldo_inicial] = @saldo_inicial
WHERE [id_cuenta] = @id_cuenta

GO
/****** Object:  StoredProcedure [dbo].[sp_transaccionesDelete]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transaccionesDelete]
(
	@id_transacciones int
)

AS

SET NOCOUNT ON

DELETE FROM [transacciones]
WHERE [id_transacciones] = @id_transacciones

GO
/****** Object:  StoredProcedure [dbo].[sp_transaccionesInsert]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transaccionesInsert]
(
	@id_categoria int,
	@monto float,
	@fecha varchar(50),
	@descripcion varchar(50),
	@id_cuenta int
)

AS

SET NOCOUNT ON

INSERT INTO [transacciones]
(
	[id_categoria],
	[monto],
	[fecha],
	[descripcion],
	[id_cuenta]
)
VALUES
(
	@id_categoria,
	@monto,
	@fecha,
	@descripcion,
	@id_cuenta
)

SELECT CAST(scope_identity() AS int)

GO
/****** Object:  StoredProcedure [dbo].[sp_transaccionesSelect]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transaccionesSelect]
(
	@id_transacciones int
)

AS

SET NOCOUNT ON

SELECT [id_transacciones],
	[id_categoria],
	[monto],
	[fecha],
	[descripcion],
	[id_cuenta]
FROM [transacciones]
WHERE [id_transacciones] = @id_transacciones

GO
/****** Object:  StoredProcedure [dbo].[sp_transaccionesSelectAll]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transaccionesSelectAll]

AS

SET NOCOUNT ON

SELECT [id_transacciones],
	[categoria].nombre_categoria,
	[monto],
	[fecha],
	[descripcion],
	[cuenta].nombre_cuenta
FROM [transacciones] transac,[Categoria], [Cuenta] cuenta
where transac.id_categoria = categoria.id_categoria and transac.id_cuenta = cuenta.id_cuenta

GO
/****** Object:  StoredProcedure [dbo].[sp_transaccionesUpdate]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transaccionesUpdate]
(
	@id_transacciones int,
	@id_categoria int,
	@monto float,
	@fecha varchar(50),
	@descripcion varchar(50),
	@id_cuenta int
)

AS

SET NOCOUNT ON

UPDATE [transacciones]
SET [id_categoria] = @id_categoria,
	[monto] = @monto,
	[fecha] = @fecha,
	[descripcion] = @descripcion,
	[id_cuenta] = @id_cuenta
WHERE [id_transacciones] = @id_transacciones

GO
/****** Object:  StoredProcedure [dbo].[sp_transferenciasDelete]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transferenciasDelete]
(
	@id_transferencia int
)

AS

SET NOCOUNT ON

DELETE FROM [transferencias]
WHERE [id_transferencia] = @id_transferencia

GO
/****** Object:  StoredProcedure [dbo].[sp_transferenciasInsert]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transferenciasInsert]
(
	@monto float,
	@fecha varchar(50),
	@descripcion varchar(200),
	@cuentaOrigen int,
	@cuentaDestino int
)

AS

SET NOCOUNT ON

INSERT INTO [transferencias]
(
	[monto],
	[fecha],
	[descripcion],
	[cuentaOrigen],
	[cuentaDestino]
)
VALUES
(
	@monto,
	@fecha,
	@descripcion,
	@cuentaOrigen,
	@cuentaDestino
)

SELECT CAST(scope_identity() AS int)

GO
/****** Object:  StoredProcedure [dbo].[sp_transferenciasSelect]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transferenciasSelect]
(
	@id_transferencia int
)

AS

SET NOCOUNT ON

SELECT [id_transferencia],
	[monto],
	[fecha],
	[descripcion],
	[cuentaOrigen],
	[cuentaDestino]
FROM [transferencias]
WHERE [id_transferencia] = @id_transferencia

GO
/****** Object:  StoredProcedure [dbo].[sp_transferenciasSelectAll]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transferenciasSelectAll]

AS

SET NOCOUNT ON

SELECT [id_transferencia],
	[monto],
	[fecha],
	[descripcion],
	[cuentaOrigen],
	[cuentaDestino]
FROM [transferencias]

GO
/****** Object:  StoredProcedure [dbo].[sp_transferenciasUpdate]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_transferenciasUpdate]
(
	@id_transferencia int,
	@monto float,
	@fecha varchar(50),
	@descripcion varchar(200),
	@cuentaOrigen int,
	@cuentaDestino int
)

AS

SET NOCOUNT ON

UPDATE [transferencias]
SET [monto] = @monto,
	[fecha] = @fecha,
	[descripcion] = @descripcion,
	[cuentaOrigen] = @cuentaOrigen,
	[cuentaDestino] = @cuentaDestino
WHERE [id_transferencia] = @id_transferencia

GO
/****** Object:  Table [dbo].[Categoria]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO

PRINT 'INICIANDO CREACION DE TABLAS'
------------------------------------- Soy Una Barra Separadora  :) ----------------------------------------
Print 'Iniciando 1 Tabla-Categoria'
CREATE TABLE [dbo].[Categoria](
	[id_categoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre_categoria] [varchar](50) NOT NULL,
	[tipo_categoria] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Categoria] PRIMARY KEY CLUSTERED 
(
	[id_categoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[cuenta]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
Print 'Finalizando Print Tabla-Categoria'
------------------------------------ Soy Una Barra Separadora :) ----------------------------------------
Print 'Iniciando 2 Tabla-Cuenta'
CREATE TABLE [dbo].[cuenta](
	[id_cuenta] [int] IDENTITY(505050,5) NOT NULL,
	[nombre_cuenta] [varchar](50) NOT NULL,
	[saldo_inicial] [float] NOT NULL,
 CONSTRAINT [PK_cuenta] PRIMARY KEY CLUSTERED 
(
	[id_cuenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[transacciones]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
Print 'Finalizando Print Tabla-Cuenta'
------------------------------------ Soy Una Barra Separadora :) ----------------------------------------
Print 'Iniciando 3 Tabla-transacciones'
CREATE TABLE [dbo].[transacciones](
	[id_transacciones] [int] IDENTITY(1,1) NOT NULL,
	[id_categoria] [int] NOT NULL,
	[monto] [float] NOT NULL,
	[fecha] [varchar](50) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
	[id_cuenta] [int] NOT NULL,
 CONSTRAINT [PK_transacciones] PRIMARY KEY CLUSTERED 
(
	[id_transacciones] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[transferencias]    Script Date: 11/06/2016 19:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
Print 'Finalizando Print Tabla-transacciones'
------------------------------------ Soy Una Barra Separadora :) ----------------------------------------
Print 'Iniciando 4 Tabla-transferencias'
CREATE TABLE [dbo].[transferencias](
	[id_transferencia] [int] IDENTITY(1,1) NOT NULL,
	[monto] [float] NOT NULL,
	[fecha] [varchar](50) NOT NULL,
	[descripcion] [varchar](200) NOT NULL,
	[cuentaOrigen] [int] NOT NULL,
	[cuentaDestino] [int] NOT NULL,
 CONSTRAINT [PK_transferencias] PRIMARY KEY CLUSTERED 
(
	[id_transferencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
Print 'Finalizando Print Tabla-transferencias'
------------------------------------ Soy Una Barra Separadora :) ----------------------------------------
SET IDENTITY_INSERT [dbo].[Categoria] ON 

INSERT [dbo].[Categoria] ([id_categoria], [nombre_categoria], [tipo_categoria]) VALUES (1, N'Ropa', N'Gastos')
INSERT [dbo].[Categoria] ([id_categoria], [nombre_categoria], [tipo_categoria]) VALUES (2, N'Comida', N'Gastos')
SET IDENTITY_INSERT [dbo].[Categoria] OFF
SET IDENTITY_INSERT [dbo].[cuenta] ON 

INSERT [dbo].[cuenta] ([id_cuenta], [nombre_cuenta], [saldo_inicial]) VALUES (2, N'sssss', 22)
INSERT [dbo].[cuenta] ([id_cuenta], [nombre_cuenta], [saldo_inicial]) VALUES (505050, N'asd', 23)
INSERT [dbo].[cuenta] ([id_cuenta], [nombre_cuenta], [saldo_inicial]) VALUES (505055, N'miguelas', 22)
INSERT [dbo].[cuenta] ([id_cuenta], [nombre_cuenta], [saldo_inicial]) VALUES (505060, N'miguelas', 22)
SET IDENTITY_INSERT [dbo].[cuenta] OFF
SET IDENTITY_INSERT [dbo].[transacciones] ON 

INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (3, 1, 500, N'1993-05-12', N'hola', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (6, 1, 23124, N'2016-5-11', N'', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (7, 1, 23124, N'2016-5-11', N'wqdqwd', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (8, 1, 1232, N'2016-5-11', N'asdas', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (9, 2, 212, N'2016-5-11', N'', 505055)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (10, 2, 212, N'2016-5-11', N'2123', 505055)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (11, 2, 123, N'2016-5-11', N'2321', 505050)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (12, 1, 23, N'2016-5-11', N'23', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (13, 1, 2312, N'2016-5-11', N'3123', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (14, 1, 2312, N'2016-5-11', N'3123', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (15, 1, 2312, N'2016-5-11', N'3123', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (16, 1, 2312, N'2016-5-11', N'3123', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (17, 1, 21312, N'2016-5-11', N'3213', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (18, 1, 21312, N'2016-5-11', N'3213', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (19, 2, 21312, N'2016-5-11', N'3213', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (20, 1, 3123, N'2016-5-11', N'213', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (21, 1, 2133, N'2016-5-11', N'1231', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (22, 1, 321, N'2016-5-11', N'231', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (23, 1, 23, N'2016-5-11', N'231', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (24, 1, 23, N'2016-5-11', N'231', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (25, 1, 23, N'2016-5-11', N'231', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (26, 1, 23, N'2016-5-11', N'231', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (27, 1, 23, N'2016-5-11', N'231', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (28, 1, 23, N'2016-5-11', N'231', 2)
INSERT [dbo].[transacciones] ([id_transacciones], [id_categoria], [monto], [fecha], [descripcion], [id_cuenta]) VALUES (29, 1, 23, N'2016-5-11', N'231', 2)
SET IDENTITY_INSERT [dbo].[transacciones] OFF
ALTER TABLE [dbo].[transacciones]  WITH CHECK ADD  CONSTRAINT [FK_transacciones_Categoria] FOREIGN KEY([id_categoria])
REFERENCES [dbo].[Categoria] ([id_categoria])
GO
ALTER TABLE [dbo].[transacciones] CHECK CONSTRAINT [FK_transacciones_Categoria]
GO
ALTER TABLE [dbo].[transacciones]  WITH CHECK ADD  CONSTRAINT [FK_transacciones_cuenta] FOREIGN KEY([id_cuenta])
REFERENCES [dbo].[cuenta] ([id_cuenta])
GO
ALTER TABLE [dbo].[transacciones] CHECK CONSTRAINT [FK_transacciones_cuenta]
GO
ALTER TABLE [dbo].[transferencias]  WITH CHECK ADD  CONSTRAINT [FK_transferencias_cuenta] FOREIGN KEY([cuentaOrigen])
REFERENCES [dbo].[cuenta] ([id_cuenta])
GO
ALTER TABLE [dbo].[transferencias] CHECK CONSTRAINT [FK_transferencias_cuenta]
GO
ALTER TABLE [dbo].[transferencias]  WITH CHECK ADD  CONSTRAINT [FK_transferencias_cuenta1] FOREIGN KEY([cuentaDestino])
REFERENCES [dbo].[cuenta] ([id_cuenta])
GO
ALTER TABLE [dbo].[transferencias] CHECK CONSTRAINT [FK_transferencias_cuenta1]
GO
