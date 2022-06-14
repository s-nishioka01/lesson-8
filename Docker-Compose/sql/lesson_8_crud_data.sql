USE date_calculation_list;
DROP TABLE IF EXISTS date_calculation_formulas;

CREATE TABLE date_calculation_formulas
(
	id INT unsigned AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	year INT NOT NULL,
	month INT NOT NULL,
	day INT NOT NULL,
	plus_or_minus VARCHAR(10) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO date_calculation_formulas (id, name, year, month, day, plus_or_minus) VALUE (1, "1年後", 1, 0, 0, "plus");
INSERT INTO date_calculation_formulas (id, name, year, month, day, plus_or_minus) VALUE (2, "1ヶ月後", 0, 1, 0, "plus");
INSERT INTO date_calculation_formulas (id, name, year, month, day, plus_or_minus) VALUE (3, "1日後", 0, 0, 1, "plus");
INSERT INTO date_calculation_formulas (id, name, year, month, day, plus_or_minus) VALUE (4, "1年前", 1, 0, 0, "minus");
INSERT INTO date_calculation_formulas (id, name, year, month, day, plus_or_minus) VALUE (5, "ダミー", 1, 0, 0, "aaa");


