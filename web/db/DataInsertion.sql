INSERT INTO ACCOUNTS (USER_ID, USER_EMAIL, USER_F_NAME, USER_L_NAME, ACCOUNT_TYPE, PASSWORD)
VALUES
    ('U-00000001', 'john.smith@gmail.com', 'John', 'Smith', 'C', 'password123'),
    ('U-00000002', 'odio@sed.ca','Nehru','Rivers', 'C', 'password123'),
    ('U-00000003', 'Sed@iderat.edu','Craig','Estrada', 'C', 'password123'),
    ('U-00000004', 'risus.quis@tortorat.org','Judah','Erickson', 'C', 'password123'),
    ('U-00000005', 'Nullam@augue.org','Hakeem','Townsend', 'C', 'password123'),
    ('U-00000006', 'consectetuer.adipiscing@Donecnibh.org','Leroy','Hoffman', 'C', 'password123'),
    ('U-00000007', 'ante.Nunc@vestibulum.com','Zachery','Acosta', 'C', 'password123'),
    ('U-00000008', 'dis.parturient.montes@malesuadafames.edu','Upton','Phelps', 'C', 'password123'),
    ('U-00000009', 'elementum.sem@utnullaCras.net','Barrett','Lewis', 'C', 'password123'),
    ('U-00000010','vulputate.velit@quisaccumsanconvallis.com','Stuart','Kramer', 'C', 'password123'),
    ('U-00000011', 'egestas.Duis.ac@Morbinon.edu','Tyler','Owens', 'C', 'password123'),
    ('U-00000012', 'nicholsonK@iotbay.com', 'Kirby','Nicholson', 'S', 'jSev*UkN1DJr'),
    ('U-00000013', 'farleyS@iotbay.com', 'Lenore','Farley', 'S', 'ilOh%@hQ&$LZ'),
    ('U-00000014', 'talleyS@iotbay.com', 'Stephanie','Talley', 'S', 'jAupTO!0DnHt')
;

INSERT INTO CUSTOMERS (USER_ID, CONTACT_NUMBER, ADDRESS_LINE_1, ADDRESS_LINE_2, SUBURB, POSTCODE, STATE, ANNONYMOUS)
VALUES
    ('U-00000001', '0438278971', '200 Wonder St', '', 'Maroubra', '2035', 'NSW', 'false'),
    ('U-00000002', '0438278972', '70 Axel Pde', '', 'Kensington', '2033' , 'NSW', 'false'),
    ('U-00000003', '0438278973', '60 Lovely St', '', 'Melbourne' , '2035', 'VIC', 'false'),
    ('U-00000004', '0438278974', '83 Oak St', '', 'Brisbane' , '3045', 'QLD', 'false'),
    ('U-00000005', '0438278975', '61 Markey St', '', 'Darwin' , '6504', 'NT', 'false'),
    ('U-00000006', '0438278976', '84 Small Ln', '', 'Hobart' , '9345', 'TAS', 'false'),
    ('U-00000007', '0438278977', '61 Anzac Pde', '', 'Perth' , '5678', 'WA', 'false'),
    ('U-00000008', '0438278978', '2 Capital St', '', 'Canberra' , '8458', 'ACT', 'false'),
    ('U-00000009', '0438278979', '54 Wonky St', '', 'Adelaide' , '4431', 'SA', 'false'),
    ('U-00000010', '0438278980', '45 Wonder St', '', 'Maroubra' , '2035', 'NSW', 'false'),
    ('U-00000011', '0438278981', '3/46', 'Wonder St', 'Maroubra', '2035', 'NSW', 'false')
;

INSERT INTO STAFF (USER_ID, IS_ADMIN)
VALUES
    ('U-00000012', 'false'),
    ('U-00000013', 'false'),
    ('U-00000014', 'false')
;

INSERT INTO PAYMENT_INFORMATION (USER_ID, CARD_NUMBER, CVV_NUMBER, EXPIRY_MONTH, EXPIRY_YEAR)
VALUES
    ('U-00000001', '5244 8746 5799 2270','832', '04', '21'),
    ('U-00000002', '536462 6527332747','858', '04', '22'),
    ('U-00000003', '5588298188999519','863', '06', '23'),
    ('U-00000004', '5301127140287588','287', '07', '20'),
    ('U-00000005', '5315328102180159','509', '11', '20'),
    ('U-00000006', '547 25471 14513 607','771', '01', '20'),
    ('U-00000007', '5483 5394 8183 4028','174', '04', '20'),
    ('U-00000008', '550 84054 11825 588','184', '03', '20'),
    ('U-00000009', '549151 905253 2532','837', '04', '20'),
    ('U-00000010', '5477537779451487','817', '02', '20'),
    ('U-00000011','523 09152 33392 109','908', '04', '21')
;

/* Insert Dashboard Data */

INSERT INTO DASHBOARD_ITEMS (ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION)
VALUES
    ('DI-0001', 'Total Revenue', 'Total revenue for the selected period'),
    ('DI-0002', 'Total Sales Count', 'Total sales count for the selected period')
;

INSERT INTO DASHBOARDS (DASHBOARD_ID, DASHBOARD_NAME, DASHBOARD_DESCRIPTION)
VALUES
    ('D-0001', 'Dashboard 1', 'Test dashboard')
;

INSERT INTO DASHBOARD_LINE_ITEMS (DASHBOARD_ID, ITEM_ID)
VALUES
    ('D-0001', 'DI-0001'),
    ('D-0001', 'DI-0002')
;