CREATE TABLE ItemProduct ( -- 商品項目
    id INTEGER NOT NULL auto_increment, -- 商品項目序號(主鍵)
    text VARCHAR(50) not null, -- 商品項目名稱
    price INTEGER NOT NULL, -- 商品單價
    inventory INTEGER NOT NULL, -- 商品庫存量
    PRIMARY KEY (id)
);

CREATE TABLE Invoice ( -- 發票
    id INTEGER NOT NULL auto_increment, -- 發票序號(主鍵)
    invdate Date not null, -- 發票日期
    PRIMARY KEY (id)
);

CREATE TABLE Item ( -- 發票項目
    id INTEGER NOT NULL auto_increment , -- 項目序號(主鍵)
    amount INTEGER NOT NULL, -- 數量
    ipid INTEGER NOT NULL, -- 商品項目序號
    invid INTEGER NOT NULL, -- 發票序號
    PRIMARY KEY (id),
    FOREIGN KEY (ipid)  REFERENCES ItemProduct(id), --重點!!! 外鍵+參照，表示鍵值與其他資料表有關連性
    FOREIGN KEY (invid) REFERENCES Invoice(id)
);