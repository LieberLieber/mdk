package org.openmbee.mdk.docgen.view.impl;

import org.openmbee.mdk.docgen.view.ColSpec;
import org.openmbee.mdk.docgen.view.DocGenViewPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Col Spec</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ColSpecImpl#getColname
 * <em>Colname</em>}</li>
 * <li>{@link ColSpecImpl#getColwidth
 * <em>Colwidth</em>}</li>
 * <li>{@link ColSpecImpl#getColnum
 * <em>Colnum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColSpecImpl extends ViewElementImpl implements ColSpec {
    /**
     * The default value of the '{@link #getColname() <em>Colname</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getColname()
     */
    protected static final String COLNAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getColname() <em>Colname</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getColname()
     */
    protected String colname = COLNAME_EDEFAULT;

    /**
     * The default value of the '{@link #getColwidth() <em>Colwidth</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getColwidth()
     */
    protected static final String COLWIDTH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getColwidth() <em>Colwidth</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getColwidth()
     */
    protected String colwidth = COLWIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getColnum() <em>Colnum</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getColnum()
     */
    protected static final int COLNUM_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getColnum() <em>Colnum</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getColnum()
     */
    protected int colnum = COLNUM_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ColSpecImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DocGenViewPackage.Literals.COL_SPEC;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getColname() {
        return colname;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setColname(String newColname) {
        String oldColname = colname;
        colname = newColname;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DocGenViewPackage.COL_SPEC__COLNAME,
                    oldColname, colname));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getColwidth() {
        return colwidth;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setColwidth(String newColwidth) {
        String oldColwidth = colwidth;
        colwidth = newColwidth;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DocGenViewPackage.COL_SPEC__COLWIDTH,
                    oldColwidth, colwidth));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getColnum() {
        return colnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setColnum(int newColnum) {
        int oldColnum = colnum;
        colnum = newColnum;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DocGenViewPackage.COL_SPEC__COLNUM, oldColnum,
                    colnum));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case DocGenViewPackage.COL_SPEC__COLNAME:
                return getColname();
            case DocGenViewPackage.COL_SPEC__COLWIDTH:
                return getColwidth();
            case DocGenViewPackage.COL_SPEC__COLNUM:
                return getColnum();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case DocGenViewPackage.COL_SPEC__COLNAME:
                setColname((String) newValue);
                return;
            case DocGenViewPackage.COL_SPEC__COLWIDTH:
                setColwidth((String) newValue);
                return;
            case DocGenViewPackage.COL_SPEC__COLNUM:
                setColnum((Integer) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case DocGenViewPackage.COL_SPEC__COLNAME:
                setColname(COLNAME_EDEFAULT);
                return;
            case DocGenViewPackage.COL_SPEC__COLWIDTH:
                setColwidth(COLWIDTH_EDEFAULT);
                return;
            case DocGenViewPackage.COL_SPEC__COLNUM:
                setColnum(COLNUM_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case DocGenViewPackage.COL_SPEC__COLNAME:
                return COLNAME_EDEFAULT == null ? colname != null : !COLNAME_EDEFAULT.equals(colname);
            case DocGenViewPackage.COL_SPEC__COLWIDTH:
                return COLWIDTH_EDEFAULT == null ? colwidth != null : !COLWIDTH_EDEFAULT.equals(colwidth);
            case DocGenViewPackage.COL_SPEC__COLNUM:
                return colnum != COLNUM_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (colname: ");
        result.append(colname);
        result.append(", colwidth: ");
        result.append(colwidth);
        result.append(", colnum: ");
        result.append(colnum);
        result.append(')');
        return result.toString();
    }

} // ColSpecImpl
