package dao;

import dto.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class CuentaDao {

	public abstract boolean insert(Cuenta obj) throws Exception;

	public abstract int update(Cuenta obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<Cuenta> getList();

	public abstract Cuenta get(int id);

}

