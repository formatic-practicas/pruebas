/*
 * Modificamos esto desde Qtcreator!
 */
#include <QtGui>
#include <QtSql>
static bool createConnection()
{
	QSqlDatabase db = QSqlDatabase::addDatabase("QSQLITE");
	db.setDatabaseName(":memory:");
	if (!db.open()) {
		QMessageBox::critical(0, "No se puede abrir la base de datos",
							  "Imposible establecer una conexi_n con la base de datos.\n"
							  "Pulsar Cancel para salir.", QMessageBox::Cancel);
		return false;
	}
	return true;
}
void initializeModel(QSqlRelationalTableModel *model)
{
	model->setTable("employee");
	model->setEditStrategy(QSqlTableModel::OnManualSubmit);
	model->setRelation(2, QSqlRelation("city", "id", "name"));
	model->setRelation(3, QSqlRelation("country", "id", "name"));
	model->setHeaderData(0, Qt::Horizontal, "ID");
	model->setHeaderData(1, Qt::Horizontal, "Name");
	model->setHeaderData(2, Qt::Horizontal, "City");
	model->setHeaderData(3, Qt::Horizontal, "Country");
	model->select();
}
QTableView *createView(const QString &title, QSqlTableModel *model)
{
	QTableView *view = new QTableView;
	view->setModel(model);
	view->setItemDelegate(new QSqlRelationalDelegate(view));
	view->setWindowTitle(title);
	return view;
}
void createRelationalTables()
{
	QSqlQuery query;
	query.exec("create table employee(id int primary key, name varchar(20), city int, country int)");
			query.exec("insert into employee values(1, 'Espen', 5000, 47)");
	query.exec("insert into employee values(2, 'Harald', 80000, 49)");
	query.exec("insert into employee values(3, 'Sam', 100, 1)");
	query.exec("create table city(id int, name varchar(20))");
	query.exec("insert into city values(100, 'San Jose')");
	query.exec("insert into city values(5000, 'Oslo')");
	query.exec("insert into city values(80000, 'Munich')");
	query.exec("insert into city values(2, 'Ourense')");

	query.exec("create table country(id int, name varchar(20))");
	query.exec("insert into country values(1, 'USA')");
	query.exec("insert into country values(47, 'Norway')");
	query.exec("insert into country values(49, 'Germany')");
	query.exec("insert into country values(32, 'Spain')");
}
int main(int argc, char *argv[])
{
	QApplication app(argc, argv);
	if (!createConnection()) return 1;
	createRelationalTables();
	QSqlRelationalTableModel model;
	initializeModel(&model);
	QTableView *view = createView("Relational Table Model", &model);
	view->show();
	return app.exec();
}
