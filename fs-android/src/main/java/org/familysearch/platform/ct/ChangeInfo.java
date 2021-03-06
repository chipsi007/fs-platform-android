/**
 * Copyright 2011 Intellectual Reserve, Inc. All Rights reserved.
 */
package org.familysearch.platform.ct;

import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


/**
 * Information about a change.
 */
@Root (strict = false)
public class ChangeInfo
{
  @Element (required = false)
  private URI operation;
  @Attribute (required = false)
  private transient URI objectType; // from ChangeOperation
  @Attribute (required = false)
  private URI objectModifier; // from ChangeObjectModifier
  @Attribute (required = false)
  private String reason;
  @Element (required = false)
  private ResourceReference parent;
  @Element (required = false)
  private ResourceReference resulting;
  @Element (required = false)
  private ResourceReference original;
  @Element (required = false)
  private ResourceReference removed;

  public ChangeInfo() {
  }

  public ChangeInfo( ChangeType type ) {
    this.operation = type.getOperation().toQNameURI();
    this.objectType = type.getObjectType().toQNameURI();
    this.objectModifier = type.getObjectModifier() != null ? type.getObjectModifier().toQNameURI() : null;
  }

  /**
   * The operation of the change.
   *
   * @return The operation of the change.
   */
  public URI getOperation() {
    return operation;
  }

  /**
   * The operation of the change.
   *
   * @param operation The operation of the change.
   */
  public void setOperation( URI operation ) {
    this.operation = operation;
  }

  /**
   * The enum referencing the known operation of the change.
   *
   * @return The enum referencing the known operation of the change.
   */
  public ChangeOperation getKnownOperation() {
    return getOperation() == null ? null : ChangeOperation.fromQNameURI( getOperation() );
  }

  /**
   * Set the operation of this change from a known enumeration of change operations.
   *
   * @param knownOperation the change operation.
   */
  public void setKnownOperation( ChangeOperation knownOperation ) {
    setOperation(knownOperation == null ? null : URI.create( EnumUtil.toURIValue( knownOperation )));
  }

  /**
   * The type of the object to which the operation applies. Values from ChangeObjectType
   *
   * @return The type of the object to which the operation applies.
   */
  public URI getObjectType() {
    return objectType;
  }

  /**
   * The type of the object to which the operation applies.
   *
   * @param objectType The type of the object to which the operation applies.
   */
  public void setObjectType( URI objectType ) {
    this.objectType = objectType;
  }

  /**
   * The enum referencing the known object type of the change.
   *
   * @return The enum referencing the known object type of the change.
   */

  public ChangeObjectType getKnownObjectType() {
    return getObjectType() == null ? null : ChangeObjectType.fromQNameURI( getObjectType() );
  }

  /**
   * Set the object of this change from a known enumeration of change objects.
   *
   * @param knownObject the change object.
   */
  public void setKnownObjectType( ChangeObjectType knownObject ) {
    setObjectType(knownObject == null ? null : URI.create( EnumUtil.toURIValue( knownObject )));
  }

  /**
   * An optional modifier for the object to which the operation applies. For example, if the object is a <tt>Fact</tt>, a
   * modifier could be applied to indicate that fact applies to a person, couple, or child-and-parents relationship.
   *
   * @return An optional modifier for the object to which the operation applies.
   */
  public URI getObjectModifier() {
    return objectModifier;
  }

  /**
   * An optional modifier for the object to which the operation applies. For example, if the object is a <tt>Fact</tt>, a
   * modifier could be applied to indicate that fact applies to a person, couple, or child-and-parents relationship.
   *
   * @param objectModifier An optional modifier for the object to which the operation applies.
   */
  public void setObjectModifier( URI objectModifier ) {
    this.objectModifier = objectModifier;
  }

  /**
   * The enum referencing the known object modifier of the change.
   *
   * @return The enum referencing the known object modifier of the change.
   */
  public ChangeObjectModifier getKnownObjectModifier() {
    return getObjectModifier() == null ? null : ChangeObjectModifier.fromQNameURI( getObjectModifier() );
  }

  /**
   * Set the object of this change from a known enumeration of change objects.
   *
   * @param knownObject the change object.
   */
  public void setKnownObjectModifier( ChangeObjectModifier knownObject ) {
    setObjectModifier(knownObject == null ? null : URI.create( EnumUtil.toURIValue( knownObject )));
  }

  /**
   * The reason for the change.
   *
   * @return The reason for the change.
   */
  public String getReason() {
    return reason;
  }

  /**
   * The reason for the change.
   *
   * @param reason The reason for the change.
   */
  public void setReason( String reason ) {
    this.reason = reason;
  }

  /**
   * The parent change that triggered, caused, or included this change.
   *
   * @return The parent change that triggered, caused, or included this change.
   */
  public ResourceReference getParent() {
    return parent;
  }

  /**
   * The parent change that triggered, caused, or included this change.
   *
   * @param parent The parent change that triggered, caused, or included this change.
   */
  public void setParent( ResourceReference parent ) {
    this.parent = parent;
  }

  /**
   * The subject representing the result of the change.
   *
   * @return The subject representing the result of the change.
   */
  public ResourceReference getResulting() {
    return resulting;
  }

  /**
   * The subject representing the result of the change.
   *
   * @param resulting The subject representing the result of the change.
   */
  public void setResulting( ResourceReference resulting ) {
    this.resulting = resulting;
  }

  /**
   * The subject representing the original value(s) that existed before the change.
   *
   * @return The subject representing the original value(s) that existed before the change.
   */
  public ResourceReference getOriginal() {
    return original;
  }

  public void setOriginal( ResourceReference original ) {
    this.original = original;
  }


  /**
   * The subject representing the removed value(s) that existed before the change.
   *
   * @return The subject representing the removed value(s) that existed before the change.
   */
  public ResourceReference getRemoved() {
    return removed;
  }

  public void setRemoved( ResourceReference removed ) {
    this.removed = removed;
  }
}
