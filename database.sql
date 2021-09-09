-- Création de la base de données
CREATE DATABASE libo COLLATE utf8_general_ci;
-- Utilisation de la base de données
USE libo;
-- Création de la table personne
CREATE TABLE client (
    CL_ID INT AUTO_INCREMENT NOT NULL,
    CL_NOM VARCHAR(50) NOT NULL,
    CL_PRENOM VARCHAR(50) NOT NULL,
    CL_ADRESSE VARCHAR(150) NOT NULL,
    CL_LOGIN VARCHAR(50),
    CL_PASSWORD VARCHAR(300),
    PRIMARY KEY (CL_ID)
) ENGINE = InnoDb;
-- Création de la table produit
CREATE TABLE livre (
    LIV_ID INT NOT NULL AUTO_INCREMENT,
    LIV_TITRE VARCHAR(50) NOT NULL,
    LIV_AUTEUR VARCHAR(50) NOT NULL,
    LIV_PRIX DECIMAL(10, 2) NOT NULL DEFAULT 0,
    LIV_PHOTO VARCHAR(250),
    LIV_RESUME VARCHAR(500),
    PRIMARY KEY (LIV_ID)
) ENGINE = InnoDb;
-- Création de la table commande
CREATE TABLE commande (
    CMD_ID INT NOT NULL AUTO_INCREMENT,
    CMD_DATE DATETIME NOT NULL DEFAULT NOW(),
    CMD_CLIENT_ID INT NOT NULL,
    CMD_MONTANT DECIMAL(10, 2) NOT NULL DEFAULT 0,
    PRIMARY KEY (CMD_ID)
) ENGINE = InnoDb;
    
  
  -- Inserts

 use libo;
insert into livre (LIV_TITRE, LIV_AUTEUR, LIV_PRIX, LIV_PHOTO, LIV_RESUME) values
("Catcher in the rye", "J.D. Salinger", "9.99", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Catcher-in-the-rye-red-cover.jpg/375px-Catcher-in-the-rye-red-cover.jpg", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."),
("The old man and the sea", "E. Hemingway", "9.99", "https://fr.web.img5.acsta.net/medias/nmedia/00/02/33/00/69216313_af.jpg", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."),
("Fear and loathing in Las Vegas", "H.S. Thompson", "8.99", "https://upload.wikimedia.org/wikipedia/en/7/7c/Fear_and_Loathing_in_Las_Vegas.jpg", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."),
("1984", "G. Orwell", "10.99", "https://images-na.ssl-images-amazon.com/images/I/413j1czxcbL._SX345_BO1,204,203,200_.jpg", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."),
("Maus", "A. Spiegelman", "15.99", "https://images2.medimops.eu/product/9c74e7/M02080675346-large.jpg", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.");


INSERT INTO client (`CL_NOM`,`CL_PRENOM`,`CL_ADRESSE`,`CL_LOGIN`,`CL_PASSWORD`) 
VALUES 
("Admin","Admin","3154 Admin Ave","admin","admin"),
("User","User","3161 User Ave","user","user"),
("Eliana","Kennan","3166 Litora Ave","kennan12","kennan123"),
("Shaeleigh","Astra","7039 Euismod St.","astra12","astra123"),
("Ferris","Xenos","Ap 673-219 Molestie Rd.","xenos12","xenos123"),
("Jael","TaShya","Ap 705-5729 Integer Road","tashya12","tashya123"),
("Catherine","Laura","Ap 187-9231 Lorem, Road","laura12","laura123"),
("Irma","Amela","544-2973 Nec, St.","amela12","amela123"),
("Wylie","Kyla","P.O. Box 836, 6745 Curabitur Street","kyla12","kyla123"),
("Mollie","Buffy","P.O. Box 106, 8331 Lorem St.","buffy12","buffy123"),
("Dustin","Kelsey","P.O. Box 284, 9063 Etiam Av.","kelsey12","kelsey123");
