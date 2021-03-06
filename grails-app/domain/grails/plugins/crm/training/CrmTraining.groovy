/*
 * Copyright (c) 2014 Goran Ehrsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package grails.plugins.crm.training

import grails.plugins.crm.core.AuditEntity
import grails.plugins.crm.core.TenantEntity
import grails.plugins.sequence.SequenceEntity

/**
 * Training metadata.
 */
@TenantEntity
@AuditEntity
@SequenceEntity
class CrmTraining {

    String number
    String name
    String description
    String url

    CrmTrainingType type

    static constraints = {
        number(maxSize: 20, blank: false, unique: 'tenantId')
        name(maxSize: 255, blank: false)
        description(maxSize: 2000, nullable: true, widget: 'textarea')
        url(maxSize: 255, nullable: true)
        type()
    }

    static mapping = {
        sort 'number'
        number index: 'crm_training_number_idx'
        url index: 'crm_training_url_idx'
    }

    static taggable = true
    static attachmentable = true
    static dynamicProperties = true
    static relatable = true
    static auditable = true

    public static final List BIND_WHITELIST = ['number', 'name', 'description', 'url', 'type']

    String toString() {
        name.toString()
    }
}
