package org.openmbee.mdk.docgen.view.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.openmbee.mdk.docgen.view.*;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 *
 * @generated
 * @see DocGenViewPackage
 */
public class DocGenViewSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static DocGenViewPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public DocGenViewSwitch() {
        if (modelPackage == null) {
            modelPackage = DocGenViewPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return whether this is a switch for the given package.
     * @parameter ePackage the package in question.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code>
     * call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case DocGenViewPackage.COL_SPEC: {
                ColSpec colSpec = (ColSpec) theEObject;
                T result = caseColSpec(colSpec);
                if (result == null) {
                    result = caseViewElement(colSpec);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.HAS_CONTENT: {
                HasContent hasContent = (HasContent) theEObject;
                T result = caseHasContent(hasContent);
                if (result == null) {
                    result = caseViewElement(hasContent);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.IMAGE: {
                Image image = (Image) theEObject;
                T result = caseImage(image);
                if (result == null) {
                    result = caseViewElement(image);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.LIST: {
                List list = (List) theEObject;
                T result = caseList(list);
                if (result == null) {
                    result = caseHasContent(list);
                }
                if (result == null) {
                    result = caseViewElement(list);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.LIST_ITEM: {
                ListItem listItem = (ListItem) theEObject;
                T result = caseListItem(listItem);
                if (result == null) {
                    result = caseHasContent(listItem);
                }
                if (result == null) {
                    result = caseViewElement(listItem);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.PARAGRAPH: {
                Paragraph paragraph = (Paragraph) theEObject;
                T result = caseParagraph(paragraph);
                if (result == null) {
                    result = caseViewElement(paragraph);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.TABLE: {
                Table table = (Table) theEObject;
                T result = caseTable(table);
                if (result == null) {
                    result = caseViewElement(table);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.TABLE_ENTRY: {
                TableEntry tableEntry = (TableEntry) theEObject;
                T result = caseTableEntry(tableEntry);
                if (result == null) {
                    result = caseHasContent(tableEntry);
                }
                if (result == null) {
                    result = caseViewElement(tableEntry);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.TEXT: {
                Text text = (Text) theEObject;
                T result = caseText(text);
                if (result == null) {
                    result = caseViewElement(text);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.VIEW_ELEMENT: {
                ViewElement viewElement = (ViewElement) theEObject;
                T result = caseViewElement(viewElement);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.TABLE_ROW: {
                TableRow tableRow = (TableRow) theEObject;
                T result = caseTableRow(tableRow);
                if (result == null) {
                    result = caseHasContent(tableRow);
                }
                if (result == null) {
                    result = caseViewElement(tableRow);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case DocGenViewPackage.MD_EDITABLE_TABLE: {
                MDEditableTable mdEditableTable = (MDEditableTable) theEObject;
                T result = caseMDEditableTable(mdEditableTable);
                if (result == null) {
                    result = caseTable(mdEditableTable);
                }
                if (result == null) {
                    result = caseViewElement(mdEditableTable);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Col Spec</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>Col Spec</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseColSpec(ColSpec object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Has Content</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>Has Content</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseHasContent(HasContent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Image</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>Image</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseImage(Image object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>List</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>List</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseList(List object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>List Item</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>List Item</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseListItem(ListItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Paragraph</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>Paragraph</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseParagraph(Paragraph object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Table</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>Table</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseTable(Table object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Table Entry</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>Table Entry</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseTableEntry(TableEntry object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Text</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>Text</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseText(Text object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>View Element</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>View Element</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseViewElement(ViewElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Table Row</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>Table Row</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseTableRow(TableRow object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>MD Editable Table</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>MD Editable Table</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     */
    public T caseMDEditableTable(MDEditableTable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>EObject</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch, but this is
     * the last case anyway. <!-- end-user-doc -->
     *
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '
     * <em>EObject</em>'.
     * @generated
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // DocGenViewSwitch
