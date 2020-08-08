INSERT INTO product_category(name) VALUES
  ('Alcohol'),
  ('Clothing'),
  ('Essentials'),
  ('Frozen Foods');

INSERT INTO product_sales(name, description, startDate, endDate) VALUES 
  ('No Sale', 'There is no discount with this entity.', null, null),
  ('Half Price', 'This decreases the product value by half.', PARSEDATETIME('08/07/2020', 'dd/MM/yyyy'), PARSEDATETIME('08/10/2020', 'dd/MM/yyyy')),
  ('25% Off', 'This decreases the product value by a quarter.', PARSEDATETIME('08/07/2020', 'dd/MM/yyyy'), PARSEDATETIME('08/10/2020', 'dd/MM/yyyy'));

INSERT INTO product (name, description, cost, categoryId, brand, onSale, saleId) VALUES
  ('Beer', 'Perfect for a piss up with the lads!', 9.99, 1, 'Carling', false, 1),
  ('Wine', 'Perfect for a night in with the wife.', 12.99, 1, 'Echo Falls', false, 1),
  ('Ale', 'How about something classic & brewed in the local area?', 15.99, 1, 'Doom Bar', false, 1),
  ('T-Shirt', 'A plain white T-Shirt, great for all occassions.', 5.99, 2, 'George', false, 1),
  ('Jeans', 'A nice pair of Levi jeans.', 90.00, 2, 'Levi', true, 2),
  ('Skirt', 'A nice skirt for the summer vibes.', 75.00, 2, 'Dorothy Perkins', true, 3),
  ('Coktail Dress', 'Perfect for a night out in town.', 60.00, 2, 'Ted Baker', false, 1),
  ('Bleach', 'Top notch bleach for getting rid of that nasty bacteria.', 10.00, 3, 'Domestos', true, 2),
  ('Mop', 'Supplied with a one year guarantee, this Vildea Turbo Smart Spin Mop.', 20.00, 3, 'Vileda ', false, 1),
  ('Hoover', 'An advanced, rechargeable battery powers the cord-free vacuum.', 249.00, 3, 'Hoover ', false, 1),
  ('Duster', 'Clean and polish your surfaces, with these Jantex yellow dusters.', 4.50, 3, 'Jantex ', false, 1);

-- For this example, the passwords have not been encrypted, in real world 
-- use cases, please encrypt passwords at ALL times!!!!! 
INSERT INTO admin (forename, surname, email, password, role) VALUES 
  ('Joe', 'Bloggs', 'Joe.Bloggs@somewebsite.com', 'p@55W0rd$123Abc', 'Website Admin'),
  ('John', 'Doe', 'John.Doe@somewebsite.com', 'I@mAw3s0me!Qwerty', 'Product Manager');