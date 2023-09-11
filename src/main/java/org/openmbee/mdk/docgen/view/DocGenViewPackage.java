package org.openmbee.mdk.docgen.view;

import org.openmbee.mdk.docgen.view.impl.*;
import org.eclipse.emf.ecore.*;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @model kind="package"
 * @generated
 * @see DocGenViewFactory
 */
public interface DocGenViewPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "dgview";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://mbee.jpl.nasa.gov/docgen/dgview";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "gov.nasa.jpl.mbee.mdk.dgview";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    DocGenViewPackage eINSTANCE = DocGenViewPackageImpl
            .init();

    /**
     * The meta object id for the '
     * {@link ViewElementImpl
     * <em>View Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     * @see ViewElementImpl
     * @see DocGenViewPackageImpl#getViewElement()
     */
    int VIEW_ELEMENT = 9;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__ID = 0;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__TITLE = 1;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__FROM_ELEMENT_ID = 2;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__FROM_PROPERTY = 3;

    /**
     * The number of structural features of the '<em>View Element</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '
     * {@link ColSpecImpl
     * <em>Col Spec</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see ColSpecImpl
     * @see DocGenViewPackageImpl#getColSpec()
     */
    int COL_SPEC = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COL_SPEC__ID = VIEW_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COL_SPEC__TITLE = VIEW_ELEMENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COL_SPEC__FROM_ELEMENT_ID = VIEW_ELEMENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COL_SPEC__FROM_PROPERTY = VIEW_ELEMENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Colname</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COL_SPEC__COLNAME = VIEW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Colwidth</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COL_SPEC__COLWIDTH = VIEW_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Colnum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COL_SPEC__COLNUM = VIEW_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Col Spec</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COL_SPEC_FEATURE_COUNT = VIEW_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '
     * {@link HasContentImpl
     * <em>Has Content</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     * @see HasContentImpl
     * @see DocGenViewPackageImpl#getHasContent()
     */
    int HAS_CONTENT = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HAS_CONTENT__ID = VIEW_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HAS_CONTENT__TITLE = VIEW_ELEMENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HAS_CONTENT__FROM_ELEMENT_ID = VIEW_ELEMENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HAS_CONTENT__FROM_PROPERTY = VIEW_ELEMENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HAS_CONTENT__CHILDREN = VIEW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Has Content</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HAS_CONTENT_FEATURE_COUNT = VIEW_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link ImageImpl
     * <em>Image</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see ImageImpl
     * @see DocGenViewPackageImpl#getImage()
     */
    int IMAGE = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE__ID = VIEW_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE__TITLE = VIEW_ELEMENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE__FROM_ELEMENT_ID = VIEW_ELEMENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE__FROM_PROPERTY = VIEW_ELEMENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Diagram Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE__DIAGRAM_ID = VIEW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Caption</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE__CAPTION = VIEW_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Gennew</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE__GENNEW = VIEW_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Do Not Show</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE__DO_NOT_SHOW = VIEW_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Image</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int IMAGE_FEATURE_COUNT = VIEW_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '
     * {@link ListImpl <em>List</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see ListImpl
     * @see DocGenViewPackageImpl#getList()
     */
    int LIST = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST__ID = HAS_CONTENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST__TITLE = HAS_CONTENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST__FROM_ELEMENT_ID = HAS_CONTENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST__FROM_PROPERTY = HAS_CONTENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST__CHILDREN = HAS_CONTENT__CHILDREN;

    /**
     * The feature id for the '<em><b>Ordered</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST__ORDERED = HAS_CONTENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>List</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST_FEATURE_COUNT = HAS_CONTENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link ListItemImpl
     * <em>List Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see ListItemImpl
     * @see DocGenViewPackageImpl#getListItem()
     */
    int LIST_ITEM = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST_ITEM__ID = HAS_CONTENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST_ITEM__TITLE = HAS_CONTENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST_ITEM__FROM_ELEMENT_ID = HAS_CONTENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST_ITEM__FROM_PROPERTY = HAS_CONTENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST_ITEM__CHILDREN = HAS_CONTENT__CHILDREN;

    /**
     * The number of structural features of the '<em>List Item</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LIST_ITEM_FEATURE_COUNT = HAS_CONTENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link ParagraphImpl
     * <em>Paragraph</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see ParagraphImpl
     * @see DocGenViewPackageImpl#getParagraph()
     */
    int PARAGRAPH = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAGRAPH__ID = VIEW_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAGRAPH__TITLE = VIEW_ELEMENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAGRAPH__FROM_ELEMENT_ID = VIEW_ELEMENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAGRAPH__FROM_PROPERTY = VIEW_ELEMENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Text</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAGRAPH__TEXT = VIEW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Paragraph</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAGRAPH_FEATURE_COUNT = VIEW_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link TableImpl
     * <em>Table</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see TableImpl
     * @see DocGenViewPackageImpl#getTable()
     */
    int TABLE = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__ID = VIEW_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__TITLE = VIEW_ELEMENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__FROM_ELEMENT_ID = VIEW_ELEMENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__FROM_PROPERTY = VIEW_ELEMENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Body</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__BODY = VIEW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Caption</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__CAPTION = VIEW_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Style</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__STYLE = VIEW_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Headers</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__HEADERS = VIEW_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Colspecs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__COLSPECS = VIEW_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Cols</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE__COLS = VIEW_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Table</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_FEATURE_COUNT = VIEW_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '
     * {@link TableEntryImpl
     * <em>Table Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     * @see TableEntryImpl
     * @see DocGenViewPackageImpl#getTableEntry()
     */
    int TABLE_ENTRY = 7;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY__ID = HAS_CONTENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY__TITLE = HAS_CONTENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY__FROM_ELEMENT_ID = HAS_CONTENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY__FROM_PROPERTY = HAS_CONTENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY__CHILDREN = HAS_CONTENT__CHILDREN;

    /**
     * The feature id for the '<em><b>Morerows</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY__MOREROWS = HAS_CONTENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Namest</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY__NAMEST = HAS_CONTENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Nameend</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY__NAMEEND = HAS_CONTENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Table Entry</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ENTRY_FEATURE_COUNT = HAS_CONTENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '
     * {@link TextImpl <em>Text</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see TextImpl
     * @see DocGenViewPackageImpl#getText()
     */
    int TEXT = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TEXT__ID = VIEW_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TEXT__TITLE = VIEW_ELEMENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TEXT__FROM_ELEMENT_ID = VIEW_ELEMENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TEXT__FROM_PROPERTY = VIEW_ELEMENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Text</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TEXT__TEXT = VIEW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Text</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TEXT_FEATURE_COUNT = VIEW_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link TableRowImpl
     * <em>Table Row</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see TableRowImpl
     * @see DocGenViewPackageImpl#getTableRow()
     */
    int TABLE_ROW = 10;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ROW__ID = HAS_CONTENT__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ROW__TITLE = HAS_CONTENT__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ROW__FROM_ELEMENT_ID = HAS_CONTENT__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ROW__FROM_PROPERTY = HAS_CONTENT__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ROW__CHILDREN = HAS_CONTENT__CHILDREN;

    /**
     * The number of structural features of the '<em>Table Row</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TABLE_ROW_FEATURE_COUNT = HAS_CONTENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link MDEditableTableImpl
     * <em>MD Editable Table</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @see MDEditableTableImpl
     * @see DocGenViewPackageImpl#getMDEditableTable()
     */
    int MD_EDITABLE_TABLE = 11;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__ID = TABLE__ID;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__TITLE = TABLE__TITLE;

    /**
     * The feature id for the '<em><b>From Element Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__FROM_ELEMENT_ID = TABLE__FROM_ELEMENT_ID;

    /**
     * The feature id for the '<em><b>From Property</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__FROM_PROPERTY = TABLE__FROM_PROPERTY;

    /**
     * The feature id for the '<em><b>Body</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__BODY = TABLE__BODY;

    /**
     * The feature id for the '<em><b>Caption</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__CAPTION = TABLE__CAPTION;

    /**
     * The feature id for the '<em><b>Style</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__STYLE = TABLE__STYLE;

    /**
     * The feature id for the '<em><b>Headers</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__HEADERS = TABLE__HEADERS;

    /**
     * The feature id for the '<em><b>Colspecs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__COLSPECS = TABLE__COLSPECS;

    /**
     * The feature id for the '<em><b>Cols</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__COLS = TABLE__COLS;

    /**
     * The feature id for the '<em><b>Precision</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__PRECISION = TABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Gui Headers</b></em>' attribute list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__GUI_HEADERS = TABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__EDITABLE = TABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Merge Cols</b></em>' attribute list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__MERGE_COLS = TABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Add Line Num</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__ADD_LINE_NUM = TABLE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Gui Body</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE__GUI_BODY = TABLE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>MD Editable Table</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MD_EDITABLE_TABLE_FEATURE_COUNT = TABLE_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '
     * {@link FromProperty
     * <em>From Property</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     * @see FromProperty
     * @see DocGenViewPackageImpl#getFromProperty()
     */
    int FROM_PROPERTY = 12;

    /**
     * Returns the meta object for class '
     * {@link ColSpec <em>Col Spec</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Col Spec</em>'.
     * @generated
     * @see ColSpec
     */
    EClass getColSpec();

    /**
     * Returns the meta object for the attribute '
     * {@link ColSpec#getColname
     * <em>Colname</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Colname</em>'.
     * @generated
     * @see ColSpec#getColname()
     * @see #getColSpec()
     */
    EAttribute getColSpec_Colname();

    /**
     * Returns the meta object for the attribute '
     * {@link ColSpec#getColwidth
     * <em>Colwidth</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Colwidth</em>'.
     * @generated
     * @see ColSpec#getColwidth()
     * @see #getColSpec()
     */
    EAttribute getColSpec_Colwidth();

    /**
     * Returns the meta object for the attribute '
     * {@link ColSpec#getColnum
     * <em>Colnum</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Colnum</em>'.
     * @generated
     * @see ColSpec#getColnum()
     * @see #getColSpec()
     */
    EAttribute getColSpec_Colnum();

    /**
     * Returns the meta object for class '
     * {@link HasContent
     * <em>Has Content</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Has Content</em>'.
     * @generated
     * @see HasContent
     */
    EClass getHasContent();

    /**
     * Returns the meta object for the containment reference list '
     * {@link HasContent#getChildren
     * <em>Children</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '
     * <em>Children</em>'.
     * @generated
     * @see HasContent#getChildren()
     * @see #getHasContent()
     */
    EReference getHasContent_Children();

    /**
     * Returns the meta object for class '
     * {@link Image <em>Image</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Image</em>'.
     * @generated
     * @see Image
     */
    EClass getImage();

    /**
     * Returns the meta object for the attribute '
     * {@link Image#getDiagramId
     * <em>Diagram Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Diagram Id</em>'.
     * @generated
     * @see Image#getDiagramId()
     * @see #getImage()
     */
    EAttribute getImage_DiagramId();

    /**
     * Returns the meta object for the attribute '
     * {@link Image#getCaption
     * <em>Caption</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Caption</em>'.
     * @generated
     * @see Image#getCaption()
     * @see #getImage()
     */
    EAttribute getImage_Caption();

    /**
     * Returns the meta object for the attribute '
     * {@link Image#isGennew
     * <em>Gennew</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Gennew</em>'.
     * @generated
     * @see Image#isGennew()
     * @see #getImage()
     */
    EAttribute getImage_Gennew();

    /**
     * Returns the meta object for the attribute '
     * {@link Image#isDoNotShow
     * <em>Do Not Show</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Do Not Show</em>'.
     * @generated
     * @see Image#isDoNotShow()
     * @see #getImage()
     */
    EAttribute getImage_DoNotShow();

    /**
     * Returns the meta object for class '
     * {@link List <em>List</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>List</em>'.
     * @generated
     * @see List
     */
    EClass getList();

    /**
     * Returns the meta object for the attribute '
     * {@link List#isOrdered
     * <em>Ordered</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Ordered</em>'.
     * @generated
     * @see List#isOrdered()
     * @see #getList()
     */
    EAttribute getList_Ordered();

    /**
     * Returns the meta object for class '
     * {@link ListItem <em>List Item</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>List Item</em>'.
     * @generated
     * @see ListItem
     */
    EClass getListItem();

    /**
     * Returns the meta object for class '
     * {@link Paragraph <em>Paragraph</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Paragraph</em>'.
     * @generated
     * @see Paragraph
     */
    EClass getParagraph();

    /**
     * Returns the meta object for the attribute '
     * {@link Paragraph#getText
     * <em>Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Text</em>'.
     * @generated
     * @see Paragraph#getText()
     * @see #getParagraph()
     */
    EAttribute getParagraph_Text();

    /**
     * Returns the meta object for class '
     * {@link Table <em>Table</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Table</em>'.
     * @generated
     * @see Table
     */
    EClass getTable();

    /**
     * Returns the meta object for the containment reference list '
     * {@link Table#getBody <em>Body</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Body</em>
     * '.
     * @generated
     * @see Table#getBody()
     * @see #getTable()
     */
    EReference getTable_Body();

    /**
     * Returns the meta object for the attribute '
     * {@link Table#getCaption
     * <em>Caption</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Caption</em>'.
     * @generated
     * @see Table#getCaption()
     * @see #getTable()
     */
    EAttribute getTable_Caption();

    /**
     * Returns the meta object for the attribute '
     * {@link Table#getStyle
     * <em>Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Style</em>'.
     * @generated
     * @see Table#getStyle()
     * @see #getTable()
     */
    EAttribute getTable_Style();

    /**
     * Returns the meta object for the containment reference list '
     * {@link Table#getHeaders
     * <em>Headers</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '
     * <em>Headers</em>'.
     * @generated
     * @see Table#getHeaders()
     * @see #getTable()
     */
    EReference getTable_Headers();

    /**
     * Returns the meta object for the containment reference list '
     * {@link Table#getColspecs
     * <em>Colspecs</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '
     * <em>Colspecs</em>'.
     * @generated
     * @see Table#getColspecs()
     * @see #getTable()
     */
    EReference getTable_Colspecs();

    /**
     * Returns the meta object for the attribute '
     * {@link Table#getCols <em>Cols</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Cols</em>'.
     * @generated
     * @see Table#getCols()
     * @see #getTable()
     */
    EAttribute getTable_Cols();

    /**
     * Returns the meta object for class '
     * {@link TableEntry
     * <em>Table Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Table Entry</em>'.
     * @generated
     * @see TableEntry
     */
    EClass getTableEntry();

    /**
     * Returns the meta object for the attribute '
     * {@link TableEntry#getMorerows
     * <em>Morerows</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Morerows</em>'.
     * @generated
     * @see TableEntry#getMorerows()
     * @see #getTableEntry()
     */
    EAttribute getTableEntry_Morerows();

    /**
     * Returns the meta object for the attribute '
     * {@link TableEntry#getNamest
     * <em>Namest</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Namest</em>'.
     * @generated
     * @see TableEntry#getNamest()
     * @see #getTableEntry()
     */
    EAttribute getTableEntry_Namest();

    /**
     * Returns the meta object for the attribute '
     * {@link TableEntry#getNameend
     * <em>Nameend</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Nameend</em>'.
     * @generated
     * @see TableEntry#getNameend()
     * @see #getTableEntry()
     */
    EAttribute getTableEntry_Nameend();

    /**
     * Returns the meta object for class '
     * {@link Text <em>Text</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Text</em>'.
     * @generated
     * @see Text
     */
    EClass getText();

    /**
     * Returns the meta object for the attribute '
     * {@link Text#getText <em>Text</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Text</em>'.
     * @generated
     * @see Text#getText()
     * @see #getText()
     */
    EAttribute getText_Text();

    /**
     * Returns the meta object for class '
     * {@link ViewElement
     * <em>View Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>View Element</em>'.
     * @generated
     * @see ViewElement
     */
    EClass getViewElement();

    /**
     * Returns the meta object for the attribute '
     * {@link ViewElement#getId
     * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Id</em>'.
     * @generated
     * @see ViewElement#getId()
     * @see #getViewElement()
     */
    EAttribute getViewElement_Id();

    /**
     * Returns the meta object for the attribute '
     * {@link ViewElement#getTitle
     * <em>Title</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Title</em>'.
     * @generated
     * @see ViewElement#getTitle()
     * @see #getViewElement()
     */
    EAttribute getViewElement_Title();

    /**
     * Returns the meta object for the attribute '
     * {@link ViewElement#getFromElementId
     * <em>From Element Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>From Element Id</em>'.
     * @generated
     * @see ViewElement#getFromElementId()
     * @see #getViewElement()
     */
    EAttribute getViewElement_FromElementId();

    /**
     * Returns the meta object for the attribute '
     * {@link ViewElement#getFromProperty
     * <em>From Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>From Property</em>'.
     * @generated
     * @see ViewElement#getFromProperty()
     * @see #getViewElement()
     */
    EAttribute getViewElement_FromProperty();

    /**
     * Returns the meta object for class '
     * {@link TableRow <em>Table Row</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Table Row</em>'.
     * @generated
     * @see TableRow
     */
    EClass getTableRow();

    /**
     * Returns the meta object for class '
     * {@link MDEditableTable
     * <em>MD Editable Table</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for class '<em>MD Editable Table</em>'.
     * @generated
     * @see MDEditableTable
     */
    EClass getMDEditableTable();

    /**
     * Returns the meta object for the attribute '
     * {@link MDEditableTable#getPrecision
     * <em>Precision</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Precision</em>'.
     * @generated
     * @see MDEditableTable#getPrecision()
     * @see #getMDEditableTable()
     */
    EAttribute getMDEditableTable_Precision();

    /**
     * Returns the meta object for the attribute list '
     * {@link MDEditableTable#getGuiHeaders
     * <em>Gui Headers</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute list '<em>Gui Headers</em>'.
     * @generated
     * @see MDEditableTable#getGuiHeaders()
     * @see #getMDEditableTable()
     */
    EAttribute getMDEditableTable_GuiHeaders();

    /**
     * Returns the meta object for the attribute list '
     * {@link MDEditableTable#getEditable
     * <em>Editable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute list '<em>Editable</em>'.
     * @generated
     * @see MDEditableTable#getEditable()
     * @see #getMDEditableTable()
     */
    EAttribute getMDEditableTable_Editable();

    /**
     * Returns the meta object for the attribute list '
     * {@link MDEditableTable#getMergeCols
     * <em>Merge Cols</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute list '<em>Merge Cols</em>'.
     * @generated
     * @see MDEditableTable#getMergeCols()
     * @see #getMDEditableTable()
     */
    EAttribute getMDEditableTable_MergeCols();

    /**
     * Returns the meta object for the attribute '
     * {@link MDEditableTable#isAddLineNum
     * <em>Add Line Num</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Add Line Num</em>'.
     * @generated
     * @see MDEditableTable#isAddLineNum()
     * @see #getMDEditableTable()
     */
    EAttribute getMDEditableTable_AddLineNum();

    /**
     * Returns the meta object for the containment reference list '
     * {@link MDEditableTable#getGuiBody
     * <em>Gui Body</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '
     * <em>Gui Body</em>'.
     * @generated
     * @see MDEditableTable#getGuiBody()
     * @see #getMDEditableTable()
     */
    EReference getMDEditableTable_GuiBody();

    /**
     * Returns the meta object for enum '
     * {@link FromProperty
     * <em>From Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>From Property</em>'.
     * @generated
     * @see FromProperty
     */
    EEnum getFromProperty();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DocGenViewFactory getDgviewFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that
     * represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     *
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '
         * {@link ColSpecImpl
         * <em>Col Spec</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @generated
         * @see ColSpecImpl
         * @see DocGenViewPackageImpl#getColSpec()
         */
        EClass COL_SPEC = eINSTANCE.getColSpec();

        /**
         * The meta object literal for the '<em><b>Colname</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute COL_SPEC__COLNAME = eINSTANCE.getColSpec_Colname();

        /**
         * The meta object literal for the '<em><b>Colwidth</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute COL_SPEC__COLWIDTH = eINSTANCE.getColSpec_Colwidth();

        /**
         * The meta object literal for the '<em><b>Colnum</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute COL_SPEC__COLNUM = eINSTANCE.getColSpec_Colnum();

        /**
         * The meta object literal for the '
         * {@link HasContentImpl
         * <em>Has Content</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         * @see HasContentImpl
         * @see DocGenViewPackageImpl#getHasContent()
         */
        EClass HAS_CONTENT = eINSTANCE.getHasContent();

        /**
         * The meta object literal for the '<em><b>Children</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EReference HAS_CONTENT__CHILDREN = eINSTANCE.getHasContent_Children();

        /**
         * The meta object literal for the '
         * {@link ImageImpl
         * <em>Image</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         * @see ImageImpl
         * @see DocGenViewPackageImpl#getImage()
         */
        EClass IMAGE = eINSTANCE.getImage();

        /**
         * The meta object literal for the '<em><b>Diagram Id</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute IMAGE__DIAGRAM_ID = eINSTANCE.getImage_DiagramId();

        /**
         * The meta object literal for the '<em><b>Caption</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute IMAGE__CAPTION = eINSTANCE.getImage_Caption();

        /**
         * The meta object literal for the '<em><b>Gennew</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute IMAGE__GENNEW = eINSTANCE.getImage_Gennew();

        /**
         * The meta object literal for the '<em><b>Do Not Show</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute IMAGE__DO_NOT_SHOW = eINSTANCE.getImage_DoNotShow();

        /**
         * The meta object literal for the '
         * {@link ListImpl
         * <em>List</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         * @see ListImpl
         * @see DocGenViewPackageImpl#getList()
         */
        EClass LIST = eINSTANCE.getList();

        /**
         * The meta object literal for the '<em><b>Ordered</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute LIST__ORDERED = eINSTANCE.getList_Ordered();

        /**
         * The meta object literal for the '
         * {@link ListItemImpl
         * <em>List Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @generated
         * @see ListItemImpl
         * @see DocGenViewPackageImpl#getListItem()
         */
        EClass LIST_ITEM = eINSTANCE.getListItem();

        /**
         * The meta object literal for the '
         * {@link ParagraphImpl
         * <em>Paragraph</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @generated
         * @see ParagraphImpl
         * @see DocGenViewPackageImpl#getParagraph()
         */
        EClass PARAGRAPH = eINSTANCE.getParagraph();

        /**
         * The meta object literal for the '<em><b>Text</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute PARAGRAPH__TEXT = eINSTANCE.getParagraph_Text();

        /**
         * The meta object literal for the '
         * {@link TableImpl
         * <em>Table</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         * @see TableImpl
         * @see DocGenViewPackageImpl#getTable()
         */
        EClass TABLE = eINSTANCE.getTable();

        /**
         * The meta object literal for the '<em><b>Body</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference TABLE__BODY = eINSTANCE.getTable_Body();

        /**
         * The meta object literal for the '<em><b>Caption</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TABLE__CAPTION = eINSTANCE.getTable_Caption();

        /**
         * The meta object literal for the '<em><b>Style</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TABLE__STYLE = eINSTANCE.getTable_Style();

        /**
         * The meta object literal for the '<em><b>Headers</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference TABLE__HEADERS = eINSTANCE.getTable_Headers();

        /**
         * The meta object literal for the '<em><b>Colspecs</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EReference TABLE__COLSPECS = eINSTANCE.getTable_Colspecs();

        /**
         * The meta object literal for the '<em><b>Cols</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TABLE__COLS = eINSTANCE.getTable_Cols();

        /**
         * The meta object literal for the '
         * {@link TableEntryImpl
         * <em>Table Entry</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         * @see TableEntryImpl
         * @see DocGenViewPackageImpl#getTableEntry()
         */
        EClass TABLE_ENTRY = eINSTANCE.getTableEntry();

        /**
         * The meta object literal for the '<em><b>Morerows</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TABLE_ENTRY__MOREROWS = eINSTANCE.getTableEntry_Morerows();

        /**
         * The meta object literal for the '<em><b>Namest</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TABLE_ENTRY__NAMEST = eINSTANCE.getTableEntry_Namest();

        /**
         * The meta object literal for the '<em><b>Nameend</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TABLE_ENTRY__NAMEEND = eINSTANCE.getTableEntry_Nameend();

        /**
         * The meta object literal for the '
         * {@link TextImpl
         * <em>Text</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         * @see TextImpl
         * @see DocGenViewPackageImpl#getText()
         */
        EClass TEXT = eINSTANCE.getText();

        /**
         * The meta object literal for the '<em><b>Text</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TEXT__TEXT = eINSTANCE.getText_Text();

        /**
         * The meta object literal for the '
         * {@link ViewElementImpl
         * <em>View Element</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         * @see ViewElementImpl
         * @see DocGenViewPackageImpl#getViewElement()
         */
        EClass VIEW_ELEMENT = eINSTANCE.getViewElement();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute VIEW_ELEMENT__ID = eINSTANCE.getViewElement_Id();

        /**
         * The meta object literal for the '<em><b>Title</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute VIEW_ELEMENT__TITLE = eINSTANCE.getViewElement_Title();

        /**
         * The meta object literal for the '<em><b>From Element Id</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute VIEW_ELEMENT__FROM_ELEMENT_ID = eINSTANCE.getViewElement_FromElementId();

        /**
         * The meta object literal for the '<em><b>From Property</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute VIEW_ELEMENT__FROM_PROPERTY = eINSTANCE.getViewElement_FromProperty();

        /**
         * The meta object literal for the '
         * {@link TableRowImpl
         * <em>Table Row</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @generated
         * @see TableRowImpl
         * @see DocGenViewPackageImpl#getTableRow()
         */
        EClass TABLE_ROW = eINSTANCE.getTableRow();

        /**
         * The meta object literal for the '
         * {@link MDEditableTableImpl
         * <em>MD Editable Table</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         * @see MDEditableTableImpl
         * @see DocGenViewPackageImpl#getMDEditableTable()
         */
        EClass MD_EDITABLE_TABLE = eINSTANCE.getMDEditableTable();

        /**
         * The meta object literal for the '<em><b>Precision</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MD_EDITABLE_TABLE__PRECISION = eINSTANCE.getMDEditableTable_Precision();

        /**
         * The meta object literal for the '<em><b>Gui Headers</b></em>'
         * attribute list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MD_EDITABLE_TABLE__GUI_HEADERS = eINSTANCE.getMDEditableTable_GuiHeaders();

        /**
         * The meta object literal for the '<em><b>Editable</b></em>' attribute
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MD_EDITABLE_TABLE__EDITABLE = eINSTANCE.getMDEditableTable_Editable();

        /**
         * The meta object literal for the '<em><b>Merge Cols</b></em>'
         * attribute list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MD_EDITABLE_TABLE__MERGE_COLS = eINSTANCE.getMDEditableTable_MergeCols();

        /**
         * The meta object literal for the '<em><b>Add Line Num</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MD_EDITABLE_TABLE__ADD_LINE_NUM = eINSTANCE.getMDEditableTable_AddLineNum();

        /**
         * The meta object literal for the '<em><b>Gui Body</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EReference MD_EDITABLE_TABLE__GUI_BODY = eINSTANCE.getMDEditableTable_GuiBody();

        /**
         * The meta object literal for the '
         * {@link FromProperty
         * <em>From Property</em>}' enum. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         * @see FromProperty
         * @see DocGenViewPackageImpl#getFromProperty()
         */
        EEnum FROM_PROPERTY = eINSTANCE.getFromProperty();

    }

} // DocGenViewPackage
